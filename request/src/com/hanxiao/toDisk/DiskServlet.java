package com.hanxiao.toDisk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/disk")
public class DiskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String protocol = request.getProtocol();
        stringBuffer.append(method + " " + uri + " " + protocol + "\n");
        stringBuffer.append(method + " " + url + " " + protocol + "\n");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            stringBuffer.append(headerName + ":" + headerValue + "\n");
        }
        String reqMessage = stringBuffer.toString();
        response.getWriter().println(reqMessage);
        ServletContext servletContext = getServletContext();
        //if 1.txt doesn't exists, it will create one.
        String realPath = servletContext.getRealPath("1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(realPath);
        fileOutputStream.write(reqMessage.getBytes());
        fileOutputStream.close();
    }
}
