package com.example.shopsb2c22.fe;

import com.example.shopsb2c22.dals.DalProduct;
import com.example.shopsb2c22.domains.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletSearch", value = "/search")
public class ServletSearch extends HttpServlet {
    DalProduct dalProduct;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("keyword");
        dalProduct = new DalProduct();
        ArrayList<Product> list = dalProduct.getProductByKeyword(search, 1, 10, "id", "DESC");
        request.setAttribute("list", list);
        request.setAttribute("keyword", search);
        request.getRequestDispatcher("/WEB-INF/fe/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
