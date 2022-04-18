package com.hanxiao.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class ApplicationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        String contextPath = httpServletRequest.getContextPath();
        String requestURI = httpServletRequest.getRequestURI();
        if ((contextPath + "/user/info").equals(requestURI)) {
            HttpSession session = httpServletRequest.getSession();
            Object username = session.getAttribute("username");
            if (username == null) {
                httpServletResponse.sendRedirect(contextPath + "/login.html");
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
