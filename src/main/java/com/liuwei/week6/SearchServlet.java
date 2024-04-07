package com.liuwei.week6;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Encoded;

import java.beans.Encoder;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String engine = req.getParameter("engine");
        String searchContent = req.getParameter("search");
        String URL = null;
        String encodeContent = URLEncoder.encode(searchContent, StandardCharsets.UTF_8);
        if (engine.equals("baidu"))
        {
            URL = "https://baidu.com/s?wd=";
            //resp.sendRedirect("https://baidu.com/s?wd=" + searchContent);
        }
        else if (engine.equals("bing"))
        {
            URL = "https://bing.com/search?q=";
            //resp.sendRedirect("https://bing.com/search?q=" + searchContent);
        }
        else if (engine.equals("google"))
        {
            URL = "https://google.com/search?q=";
            //resp.sendRedirect("https://google.com/search?q=" + searchContent);
        }
        resp.sendRedirect(URL + encodeContent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
