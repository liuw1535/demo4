package com.liuwei.week7;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author dabing
 */
@WebListener
public class JDBCServletContextListener implements ServletContextListener {//not a servlet
    /**
     * @author dabing
     */
    public JDBCServletContextListener() {
    }

    /**
     *
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("i am in contextDestroyed()");
        ServletContext context = event.getServletContext();
        Connection con=(Connection) context.getAttribute("con");
        try {
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        context.removeAttribute("con");
    }

    /**
     *
     * @param event
     */
    public void contextInitialized(ServletContextEvent event) {//like main in java program 
        System.out.println("i am in contextInitialized()");
        ServletContext context = event.getServletContext();
        String driver = context.getInitParameter("driver");//set in web.xml and get it here ? its easy to change
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("Username");
        String password = context.getInitParameter("Password");

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("in contextInitialized()-->con --> " + con);
            context.setAttribute("con", con);//for all jsp and servlet 
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}

