package com.hanxiao.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie/info")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name)) {
                    String value = cookie.getValue();
                    response.getWriter().println("欢迎你！" + value);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if ("lastLogin".equals(name)) {
                    String lastLoginTime = cookie.getValue();
                    Date date = new Date(Long.parseLong(lastLoginTime));
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formatDate = simpleDateFormat.format(date);
                    String s = "上次进入该页面时间: " + formatDate;
                    response.getWriter().println(s);
                }
            }
        }
        Cookie lastLogin = new Cookie("lastLogin", System.currentTimeMillis() + "");

        response.addCookie(lastLogin);
    }
}
