package com.example.shopsb2c22.admin.user;

import com.example.shopsb2c22.dals.DalUser;
import com.example.shopsb2c22.domains.User;
import com.example.shopsb2c22.services.Helper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletUserList", value = "/user")
public class ServletUserList extends HttpServlet implements IUser {
    DalUser dalUser;
    int page = 1;
    int limit = 10;
    String orderBy = User.COL_ID;
    String orderType = "DESC";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dalUser = new DalUser();
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "delete":
                    dalUser.delete(new Long(request.getParameter("id")));
                    HttpSession session = request.getSession();
                    session.setAttribute("success", "Delete successfully");
                    response.sendRedirect(Helper.BASE_URL + "/user");
                    break;

                case "edit":
                    response.sendRedirect(Helper.BASE_URL + "/user-edit?id=" + request.getParameter("id"));
                    break;
            }
        } else {
            Double totalPage = Math.ceil(dalUser.getTotal().doubleValue() / new Double(limit).doubleValue());
            System.out.println("total page" + totalPage);
            page = (request.getParameter("page") == null) ? 1 : Integer.parseInt(request.getParameter("page"));
            ArrayList<User> list = dalUser.getList(page, limit, orderBy, orderType);
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
