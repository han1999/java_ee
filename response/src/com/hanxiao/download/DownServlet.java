package com.hanxiao.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/down")
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Disposition", "attachment;filename=1.JPG");
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("1.JPG");

        File file = new File(realPath);
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        int len=0;
        byte[] bytes = new byte[4096];
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
        outputStream.flush();
    }
}
