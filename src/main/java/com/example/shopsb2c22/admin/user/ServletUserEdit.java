package com.example.shopsb2c22.admin.user;

import com.example.shopsb2c22.dals.DalUser;
import com.example.shopsb2c22.domains.User;
import com.example.shopsb2c22.services.Helper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletUserEdit", value = "/user-edit")
public class ServletUserEdit extends HttpServlet implements IUser {
    DalUser dalUser;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dalUser = new DalUser();
        User user = dalUser.getOne(new Long(request.getParameter("id")).longValue());
        request.setAttribute("obj", user);
        request.getRequestDispatcher(VIEW_NAME + "edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Integer permission = new Integer(request.getParameter("permission")).intValue();
        User user = new User();
        user.setEmail(email);
        user.setPassword(Helper.getMd5(password));
        user.setPhone(phone);
        user.setAddress(address);
        user.setPermission(permission);
        user.setId(new Long(request.getParameter("id")).longValue());
        dalUser = new DalUser();
        if (dalUser.update(user)) {
            //add flash session success
            HttpSession session = request.getSession();
            session.setAttribute("success", "Updated successfully");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "Update failed");
        }
        response.sendRedirect(Helper.BASE_URL + "/user-edit?id=" + user.getId());
    }
}
