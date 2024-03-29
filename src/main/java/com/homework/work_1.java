package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;

public class work_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Date date = new Date();
        String ID = "2022211001000513";
        String name = "Liu Wei";
        out.print("NAME:" + name + "\n" + "ID:" + ID + "\n" + "DATA:" + date);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
