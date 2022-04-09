package com.hanxiao.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfigServlet", urlPatterns = "/config",
        initParams = {@WebInitParam(name = "name", value = "hanxiao"),
                @WebInitParam(name = "age", value = "18")})
public class ConfigServlet extends HttpServlet {
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
