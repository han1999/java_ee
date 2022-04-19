package com.hanxiao.controller;

import com.hanxiao.model.User;
import com.hanxiao.service.UserService;
import com.hanxiao.service.UserServiceImpl2;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class MVCRegisterServlet extends javax.servlet.http.HttpServlet {
    //    UserDao userDao=new UserJsonDao();
//    UserService userService = new UserServiceImpl1();
    UserService userService = new UserServiceImpl2();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = (String) request.getAttribute("action");
        if ("register".equals(action)) {
            register(request, response);
        } else if ("login".equals(action)) {
            login(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User registerUser = new User();
        try {
            BeanUtils.populate(registerUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String username = registerUser.getUsername();
        String password = registerUser.getPassword();
        String confirmPassword = registerUser.getConfirmPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(confirmPassword)) {
            response.getWriter().println("参数不全!重新填写！");
            response.setHeader("refresh", "1;url=" + request.getContextPath());
            return;
        }
        if (!password.equals(confirmPassword)) {
            response.getWriter().println("前后输入不一致！重新输入！");
            response.setHeader("refresh", "1;url=" + request.getContextPath());
            return;
        }
//        boolean registerOk = UserJsonDao.register(registerUser);
//        boolean registerOk = userDao.register(registerUser);
        boolean registerOk = userService.register(registerUser);
        if (!registerOk) {
            response.getWriter().println("已注册过，请登录！");
        } else {
            response.getWriter().println("注册成功！请登录！");
        }
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public void function() {
//        userDao.method1();
//        userDao.method2();
//        userDao.method3();
//        userDao.method4();
//        userDao.method5();
        userService.function();

    }
}
