package com.liuwei.week8;

import com.liuwei.week7.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = (Connection) getServletContext().getAttribute("con");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int id = Integer.parseInt(req.getParameter("ID"));
        String email = req.getParameter("email");
        String birthday = req.getParameter("birthday");
        String sql = "update usertable set name = ?, password = ?, email = ?, birthday = ? where ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,password);
            statement.setString(3,email);
            statement.setString(4,birthday);
            statement.setInt(5,id);
            statement.executeUpdate();
            HttpSession session = req.getSession(false);
            session.setAttribute("User",new User(name,password,id,birthday,email));
            resp.sendRedirect("UserInfo.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
