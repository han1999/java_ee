package com.hanxiao.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            request.setAttribute("username", username);
           jump1(request,response);
//           jump2(request,response);
//            jump3(request, response);
        }
    }

    private void jump3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(302);
        response.sendRedirect(request.getContextPath()+"/info");
    }

    private void jump2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("登录成功，即将跳转！");
        response.setHeader("refresh", "2;url=" + request.getContextPath() + "/info");
    }

    private void jump1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/info");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
