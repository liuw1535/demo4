package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        value = "/config",
        initParams = {
                @WebInitParam(name = "StudentName", value = "Liu_Wei"),
                @WebInitParam(name = "StudentID", value = "2022211001000513"),
                @WebInitParam(name = "name", value = "LiuWei"),
                @WebInitParam(name = "ID", value = "2022211001000513")
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String id = getServletConfig().getInitParameter("ID");
        String name1 = getServletConfig().getInitParameter("StudentName");
        String id1 = getServletConfig().getInitParameter("StudentID");
        PrintWriter out = resp.getWriter();
        out.print("<h1>Task 1-Get init parameters from web.xml</h1>");
        out.print("Name:" + name + "<br>" + "ID:" + id);
//        out.print("<h1>Task 2-Get init parameters from @WebServlet</h1>");
//        out.print("Name:" + name1 + "<br>" + "ID:" + id1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
