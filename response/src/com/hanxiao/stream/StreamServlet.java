package com.hanxiao.stream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/stream")
public class StreamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("WEB-INF/1.JPG");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        int length=0;
        byte[] bytes = new byte[4096];
        while ((length=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, length);
        }
        fileInputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
