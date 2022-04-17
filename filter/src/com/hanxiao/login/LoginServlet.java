package com.hanxiao.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/*")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = (String) request.getAttribute("action");
//        String requestURI = request.getRequestURI();
//        String action = requestURI.replace(request.getContextPath() + "/user/", "");
        System.out.println("action = " + action);
        if ("login".equals(action)) {
            login(request, response);
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //JDBC
        response.getWriter().println("登录成功，即将跳转！");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        response.setHeader("refresh", "1;url="+request.getContextPath()+"/user/info");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = (String) request.getAttribute("action");
//        String requestURI = request.getRequestURI();
//        String action = requestURI.replace(request.getContextPath() + "/user/", "");
        System.out.println("action = " + action);
        if ("info".equals(action)) {
            info(request, response);
        } else if ("logout".equals(action)) {
            logout(request,response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.getWriter().println("即将跳转到登录页面");
        response.setHeader("refresh", "1;url="+request.getContextPath()+"/login.html");
    }

    private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        response.getWriter().println("欢迎你！ "+username);
        response.getWriter().println("<a href='"+request.getContextPath()+"/user/logout"+"'>注销</a>");
    }
}
