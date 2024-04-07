package com.homework;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    static Connection connection;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("Username");
        String password = getServletContext().getInitParameter("Password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("Username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String data = req.getParameter("data");

        int id = 0;
        String password1;
        String name;
        String email1;
        String birthday;

        PrintWriter out = resp.getWriter();
//        out.print("UserName:" + username + "\n" + "Password:" + password + "\n"
//                + "Sex:" + sex + "\n"
//                + "Email:" + email + "\n" + "BirthData:" + data
//        );
        getServletContext().setAttribute("con",connection);
        try {
            String sql = "insert into usertable values (?,?,?,?,null)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,sex);
            statement.setString(3,email);
            statement.setString(4,data);
            statement.executeUpdate();
            resp.sendRedirect("Login.jsp");
//            sql = "select * from usertable";
//            statement = connection.prepareStatement(sql);
//            ResultSet result = statement.executeQuery();
//            out.print("<table style = 'border-collapse: collapse;' border = '1'><tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Birthday</th></tr>");
//            while (result.next())
//            {
//                password1 = result.getString("password");
//                name      = result.getString("name");
//                email1    = result.getString("email");
//                birthday  = result.getString("birthday");
//                id        = result.getInt("ID");
//                out.print("<tr><td>"+id+"</td><td>"+name+"</td><td>"+password1+"</td><td>"+email1+"</td><td>"+birthday+"</td></tr>");
//            }
//            out.print("</table>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
