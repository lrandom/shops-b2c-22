package com.example.shopsb2c22.admin;

import com.example.shopsb2c22.services.Helper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(name = "ServletServeImage", value = "/image")
public class ServletServeImage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        String filePath = Helper.UPLOAD_FOLDER + path;
        response.setContentType("image/png");
        FileInputStream fis = null;
        String[] fileNames = path.split("\\.");
        String ext = fileNames[fileNames.length - 1];
        int i = 0;
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(filePath);
            while ((i = fis.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, i);
            }
        } catch (Exception e) {
            filePath = Helper.UPLOAD_FOLDER + "placeholder.png";
            response.setContentType("image/" + ext);
            buffer = new byte[1024];
            try {
                fis = new FileInputStream(filePath);
                while ((i = fis.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, i);
                }
            } catch (Exception e1) {

            }
        }

        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
