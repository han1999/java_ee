package com.hanxiao.upload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/upload1")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        ServletInputStream inputStream = request.getInputStream();
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/image/1.jpg");
        System.out.println("realPath = " + realPath);
        File file = new File(realPath);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int len=0;
        byte[] bytes = new byte[4096];
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
