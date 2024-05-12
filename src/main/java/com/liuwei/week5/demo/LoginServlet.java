package com.liuwei.week5.demo;

import com.liuwei.week7.pojo.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        String username = req.getParameter("name");
        String psd = req.getParameter("password");
        String isRem = req.getParameter("isRem");
        Cookie cookie = new Cookie("name",username);
        if (isRem == null)
        {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        else if(isRem.equals("true"))
        {
            resp.addCookie(cookie);
        }
        PrintWriter out = resp.getWriter();
//        Cookie cookie = new Cookie("username", "example");
//        cookie.setMaxAge(1);
//        resp.addCookie(cookie);
//        HttpSession session = req.getSession();
//        System.out.println("sessionId:"+session.getId());
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,psd);
            ResultSet result = statement.executeQuery();
//            if(result.next())
//            {
//                out.print("<h1>Login success!</h1>");
//                out.print("<span>Welcome " + username + "</span>");
//            }
//            else
//            {
//                out.print("<h1>Login failed!</h1>" +
//                        "<span>user does not exit</span>");
//            }
            if(result.next())
            {
                int ID = result.getInt("ID");
                String birthday = result.getString("birthday");
                String email = result.getString("email");
                HttpSession session = req.getSession();
                session.setAttribute("User",new User(username,psd,ID,birthday,email));
                //req.getRequestDispatcher("UserInfo.jsp").forward(req,resp);
                resp.sendRedirect("views/index.jsp");
            }
            else
            {
                //resp.sendRedirect("Login.jsp");
                resp.sendRedirect("views/login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
