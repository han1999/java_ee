package com.hanxiao.reflection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/17
 **/
@WebServlet("/ref")
public class Ref extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        ClassLoader classLoader = Ref.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("hello.txt");
        int len=0;
        byte[] bytes = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len = resourceAsStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        resourceAsStream.close();
    }
}
