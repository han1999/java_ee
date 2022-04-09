package com.hanxiao.life;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/8
 **/
//@WebServlet(urlPatterns = "/life", loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("servlet init!");
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("servlet destroy!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.getWriter().println("servlet get!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.getWriter().println("servlet post!");
    }
}
