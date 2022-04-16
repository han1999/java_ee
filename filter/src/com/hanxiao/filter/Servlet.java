package com.hanxiao.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/filter",loadOnStartup = 1)
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("servlet");
    }

    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("servlet init");
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("servlet destroy");
    }
}
