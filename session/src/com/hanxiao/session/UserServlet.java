package com.hanxiao.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request, response);
        if ("login".equals(action)) {
            login(request, response);
        }
    }

    private String getAction(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String requestURI = request.getRequestURI();
        //URI  ----> /appname/*
        System.out.println("requestURI = " + requestURI);
        return requestURI.replace(request.getContextPath() + "/user/", "");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(180);
        response.addCookie(cookie);
        session.setAttribute("username", username);
        response.getWriter().println("登录成功，即将跳转！");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/user/info");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request, response);
        if ("info".equals(action)) {
            info(request, response);
        } else if ("logout".equals(action)) {
            logout(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/");
    }

    private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
//        session.invalidate();
        String username = (String) session.getAttribute("username");
        String id = session.getId();
        System.out.println("session = " + session);
        System.out.println("id = " + id);
        response.getWriter().println("欢迎您！" + username);
        response.getWriter().println("<a href='" + request.getContextPath() + "/user/logout" + "'>" + "注销" + "</a>");
    }
}
