package com.example.shopsb2c22.fe;

import com.example.shopsb2c22.dals.DalProduct;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletProductDetail", value = "/product-detail")
public class ServletProductDetail extends HttpServlet {
    DalProduct dalProduct;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        dalProduct = new DalProduct();
        request.setAttribute("product", dalProduct.getOne(Long.parseLong(id)));
        request.getRequestDispatcher("WEB-INF/fe/product-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
