package com.example.shopsb2c22.admin.product;

import com.example.shopsb2c22.dals.*;
import com.example.shopsb2c22.domains.Product;
import com.example.shopsb2c22.services.Helper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@WebServlet(name = "ServletProductAdd", value = "/product-add")
@MultipartConfig
public class ServletProductAdd extends HttpServlet implements IProduct {
    DalCategory dalCategory = new DalCategory();
    DalColor dalColor = new DalColor();
    DalMaterial dalMaterial = new DalMaterial();
    DalSize dalSize = new DalSize();
    Conn conn = null;
    DalProduct dalProduct = new DalProduct();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dalCategory = new DalCategory();
        dalColor = new DalColor();
        dalMaterial = new DalMaterial();
        dalSize = new DalSize();
        dalProduct = new DalProduct();
        request.setAttribute("categories", dalCategory.getList(1, 100, "id", "DESC"));
        request.setAttribute("color", dalColor.getList(1, 100, "id", "DESC"));
        request.setAttribute("material", dalMaterial.getList(1, 100, "id", "DESC"));
        request.setAttribute("size", dalSize.getList(1, 100, "id", "DESC"));
        request.getRequestDispatcher(VIEW_NAME + "add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String content = request.getParameter("content");
        System.out.println("PRICE" + price);
        String categoryId = request.getParameter("category_id");

        String[] colorIds = request.getParameterValues("color_id");

        String[] materialIds = request.getParameterValues("material_id");

        String[] sizeIds = request.getParameterValues("size_id");

        String metaDescription = request.getParameter("meta_description");
        String metaKeyword = request.getParameter("meta_keyword");
        String metaTitle = request.getParameter("meta_title");
        String quantity = request.getParameter("quantity");


        Product product = new Product();
        product.setName(name);
        product.setPrice(new Double(price));
        product.setCategoryId(Long.parseLong(categoryId));
        product.setContent(content);
        product.setMeta_description(metaDescription);
        product.setMeta_keyword(metaKeyword);
        product.setMeta_title(metaTitle);
        product.setQuantity(Integer.parseInt(quantity));
        long productId = dalProduct.addAndGetId(product);
        if (productId > 0) {
            //chèn thành công product, tiến hành chèn bản ghi vào bảng
            //product_material
            //product_color
            //product_size
            conn = new Conn();
            try {
                Statement stm = conn.getConn().createStatement();
                for (String materialId : materialIds) {
                    stm.executeUpdate("INSERT INTO product_material (product_id, material_id) VALUES (" + productId + "," + materialId + ")");
                }

                for (String colorId : colorIds) {
                    System.out.println("colorId" + colorId);
                    stm.executeUpdate("INSERT INTO product_color (product_id, color_id) VALUES (" + productId + "," + colorId + ")");
                }

                for (String sizeId : sizeIds) {
                    System.out.println("sizeId" + sizeId);
                    stm.executeUpdate("INSERT INTO product_size (product_id, size_id) VALUES (" + productId + "," + sizeId + ")");
                }


                //11/2021
                //12/2021
                //01/2022
                Date date = new Date();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate.getYear();//2021
                int month = localDate.getMonthValue();//11
                String newDir = year + "_" + month; //2021_11


                //check if image is uploaded
                for (int i = 1; i <= 3; i++) {
                    if (request.getPart("img_" + i) != null && request.getPart("img_" + i).getSize() > 0) {
                        Part part = request.getPart("img_" + i);
                        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

                        String[] fileNames = fileName.split("\\.");
                        String ext = fileNames[fileNames.length - 1];
                        String newName = productId + "_" + i + "_" + System.currentTimeMillis() + "." + ext;
                        InputStream inputStream = part.getInputStream();
                        String filePath = Helper.UPLOAD_FOLDER + newDir; ///Users/lrandom/Documents/jsp_upload_file/2021_11
                        if (!new File(filePath).exists() || !new File(filePath).isDirectory()) {
                            new File(filePath).mkdirs(); //tạo mới thư mục
                        }
                        filePath = filePath + File.separator + newName; //"/" "\"

                        int readData = 0;
                        FileOutputStream fout = new FileOutputStream(filePath);
                        while ((readData = inputStream.read()) != -1) {
                            fout.write(readData);
                        }
                        fout.close();
                        String imgPath = newDir + "/" + newName;
                        stm.executeUpdate("INSERT INTO images (product_id, path) VALUES (" + productId + ",'" + imgPath + "')");
                    }
                }
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("/admin/product");
        } else {
            response.sendRedirect("/admin/product/add");
        }
    }
}
