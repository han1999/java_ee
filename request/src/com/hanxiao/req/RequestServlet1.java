package com.hanxiao.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/8
 **/
@WebServlet("/req1")
public class RequestServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        StringBuffer stringBuffer = new StringBuffer();
        String method = req.getMethod();
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI();
        String protocol = req.getProtocol();
        stringBuffer.append(method + " " + uri + " " + protocol + "\n");
        stringBuffer.append(method + " " + url + " " + protocol + "\n");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            stringBuffer.append(headerName + ":" + headerValue + "\n");
        }
        resp.getWriter().println(stringBuffer.toString());
    }
}
