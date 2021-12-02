package com.example.shopsb2c22.fe;

import com.example.shopsb2c22.dals.DalProduct;
import com.example.shopsb2c22.domains.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletHome", value = "/")
public class ServletHome extends HttpServlet {
    DalProduct dalProduct;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dalProduct = new DalProduct();
        ArrayList<Product> latestProducts = dalProduct.getList(1, 12, "id", "DESC");
        ArrayList<Product> topProducts = dalProduct.getList(1, 12, "sale_quantity", "DESC");
        request.setAttribute("latestProducts", latestProducts);
        request.setAttribute("topProducts", topProducts);
        dalProduct.close();
        request.getRequestDispatcher("WEB-INF/fe/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
