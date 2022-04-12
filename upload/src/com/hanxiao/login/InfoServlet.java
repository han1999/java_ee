package com.hanxiao.login;

import com.hanxiao.beans.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = getServletContext();
        User user = (User) servletContext.getAttribute("user");
        String username = user.getUsername();
        String password = user.getPassword();
        String image = user.getImage();
        String imageUri=request.getContextPath()+"/"+image;
        response.getWriter().println("<div>"+username+"</div>");
        response.getWriter().println("<div>"+password+"</div>");
        response.getWriter().println("<div><img src='"+imageUri+"'/></div>");
    }
}
