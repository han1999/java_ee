package com.hanxiao.pic;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/pic/*")
public class PicServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
//        String op = servletPath.replace("/pic/", "");
        String op = requestURI.replace(request.getContextPath() + "/pic/", "");
        System.out.println("op = " + op);
//        String op = request.getParameter("op");
        if ("view".equals(op)){
            view(request, response);
        }else if ("down".equals(op)){
            down(request, response);
        }
    }

    private void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename=1.JPG");
        view(request,response);
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = getServletContext().getRealPath("1.JPG");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        int len=0;
        byte[] bytes = new byte[8192];
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
        outputStream.flush();
    }

}
