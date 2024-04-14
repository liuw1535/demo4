package com.liuwei.week7.servlet;

import com.liuwei.week7.pojo.User;
import com.liuwei.week7.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/QueryAllServlet")
public class QueryAllServlet extends HttpServlet {
    private Connection con;
    UserService service = new UserService();
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<User> users = service.QueryAllUser(con);
            req.setAttribute("users",users);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            req.getRequestDispatcher("View.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
