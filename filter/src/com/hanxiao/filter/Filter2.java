package com.hanxiao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/filter")
public class Filter2 implements Filter {
    public void destroy() {
        System.out.println("filter2 destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.getWriter().println("filter2 before\n");
        chain.doFilter(req, resp);
        resp.getWriter().println("filter2 after\n");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter2 init");
    }

}
