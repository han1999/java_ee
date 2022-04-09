package com.hanxiao.toBean;

import com.hanxiao.bean.User;
import com.hanxiao.util.ReflectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/toBean1")
public class ToBeanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = new User();
//        Class<? extends User> userClass = user.getClass();
//        try {
//            Method setUsername = userClass.getDeclaredMethod("setUsername", String.class);
//            Method setPassword = userClass.getDeclaredMethod("setPassword", String.class);
//            Method setGender = userClass.getDeclaredMethod("setGender", String.class);
//            Method setHobby = userClass.getDeclaredMethod("setHobby", String[].class);
//            Enumeration<String> parameterNames = request.getParameterNames();
//            while (parameterNames.hasMoreElements()) {
//                String name = parameterNames.nextElement();
//                String[] values = request.getParameterValues(name);
//                if ("username".equals(name)) {
//                    setUsername.invoke(user, values[0]);
//                } else if ("password".equals(name)) {
//                    setPassword.invoke(user, values[0]);
//                } else if ("gender".equals(name)) {
//                    setGender.invoke(user, values[0]);
//                } else if ("hobby".equals(name)) {
//                    setHobby.invoke(user, (Object)values);
//                }
//            }
//            System.out.println("user = " + user);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        User user = new User();
        try {
            ReflectionUtils.toBean(user, request.getParameterMap());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
