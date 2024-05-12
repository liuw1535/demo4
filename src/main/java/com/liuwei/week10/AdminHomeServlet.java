package com.liuwei.week10;

import com.liuwei.week7.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null)
        {
            resp.sendRedirect("views/login.jsp");
        }
        else
        {
            Object user = session.getAttribute("User");
            User u;
            if (user != null)
            {
                u = (User)user;
                if (u.getName().equals("admin"))
                {
                    resp.sendRedirect("views/admin/index.jsp");
                }
                else
                {
                    resp.sendRedirect("views/login.jsp");
                }
            }
            else
            {
                resp.sendRedirect("views/login.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
