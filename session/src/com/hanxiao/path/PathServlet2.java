package com.hanxiao.path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/path2")
public class PathServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if ("path".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    response.getWriter().println(value);
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath()+"/path2");
                    response.addCookie(cookie);
                }
            }
        }
    }
}
