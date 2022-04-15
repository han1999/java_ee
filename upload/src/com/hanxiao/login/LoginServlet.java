package com.hanxiao.login;

import com.hanxiao.beans.User;
import com.hanxiao.util.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if (!multipartContent) {
            response.getWriter().println("没有数据文件");
            return;
        }
        User user = new User();
        Map<String, Object> paramsMap = FileUploadUtils.getParamsMap(request);
        try {
            BeanUtils.populate(user, paramsMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
        response.getWriter().println("登录成功，即将跳转！");
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("user", user);
        System.out.println(request.getContextPath());
        //getContextPath's value begins with '/'
        response.setHeader("refresh", "3;url="+request.getContextPath()+"/info");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
