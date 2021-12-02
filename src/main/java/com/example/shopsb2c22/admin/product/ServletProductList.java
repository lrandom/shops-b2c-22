package com.example.shopsb2c22.admin.product;

import com.example.shopsb2c22.dals.DalProduct;
import com.example.shopsb2c22.domains.Product;
import com.example.shopsb2c22.services.Helper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletProductList", value = "/product-list")
public class ServletProductList extends HttpServlet implements IProduct {
    DalProduct productDal;
    int page = 1;
    int limit = 10;
    String orderBy = Product.COL_ID;
    String orderType = "DESC";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productDal = new DalProduct();
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "delete":
                    productDal.delete(new Long(request.getParameter("id")));
                    HttpSession session = request.getSession();
                    session.setAttribute("success", "Delete successfully");
                    response.sendRedirect(Helper.BASE_URL + "/product-list");
                    break;

                case "edit":
                    response.sendRedirect(Helper.BASE_URL + "/product-edit?id=" + request.getParameter("id"));
                    break;
            }
        } else {
            Double totalPage = Math.ceil(productDal.getTotal().doubleValue() / new Double(limit).doubleValue());
            System.out.println("total page" + totalPage);
            page = (request.getParameter("page") == null) ? 1 : Integer.parseInt(request.getParameter("page"));
            ArrayList<Product> list = productDal.getList(page, limit, orderBy, orderType);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("activePage", page);
            request.setAttribute("list", list);
            request.getRequestDispatcher(this.VIEW_NAME + "list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
