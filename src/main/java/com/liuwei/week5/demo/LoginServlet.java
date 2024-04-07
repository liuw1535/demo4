package com.liuwei.week5.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    static Connection connection;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("Username");
//        String password = getServletContext().getInitParameter("Password");
//        try {
//            Class.forName(driver);
//            connection = DriverManager.getConnection(url,username,password);
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection =  (Connection) getServletContext().getAttribute("con");
        String sql = "select * from usertable where name = ? and password = ?";
        String username = req.getParameter("Username");
        String psd = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,psd);
            ResultSet result = statement.executeQuery();
            if(result.next())
            {
                out.print("<h1>Login success!</h1>");
                out.print("<span>Welcome " + username + "</span>");
            }
            else
            {
                out.print("<h1>Login failed!</h1>" +
                        "<span>user does not exit</span>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
