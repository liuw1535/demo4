package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("Username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String data = req.getParameter("data");
        PrintWriter out = resp.getWriter();
        out.print("UserName:" + username + "\n" + "Password:" + password + "\n"
                + "Sex:" + sex + "\n"
                + "Email:" + email + "\n" + "BirthData:" + data
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
