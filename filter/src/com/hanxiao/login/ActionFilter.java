package com.hanxiao.login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/user/*")
public class ActionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //downward transformation doesn't create a new object
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        //Reference data type
//        Product product = new Product();
//        Product product1 = product;
//        System.out.println("product = " + product);
//        System.out.println("product1 = " + product1);
//        System.out.println(req);
//        System.out.println(httpServletRequest);
        String requestURI = httpServletRequest.getRequestURI();
        String action = requestURI.replace(httpServletRequest.getContextPath() + "/user/", "");
        httpServletRequest.setAttribute("action", action);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
