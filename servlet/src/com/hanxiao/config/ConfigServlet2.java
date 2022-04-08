package com.hanxiao.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfigServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("config get!");
        ServletConfig servletConfig = getServletConfig();
        String name = servletConfig.getInitParameter("name");
        String age = servletConfig.getInitParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}
