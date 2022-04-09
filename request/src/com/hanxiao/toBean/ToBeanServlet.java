package com.hanxiao.toBean;

import com.hanxiao.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

@WebServlet("/toBean1")
public class ToBeanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        try {
            Method setUsername = userClass.getDeclaredMethod("setUsername", String.class);
            Method setPassword = userClass.getDeclaredMethod("setPassword", String.class);
            Method setGender = userClass.getDeclaredMethod("setGender", String.class);
            Method setHobby = userClass.getDeclaredMethod("setHobby", String[].class);
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String[] values = request.getParameterValues(name);
                if (name == "username") {
                    setUsername.invoke(user, values[0]);
                } else if (name == "password") {
                    setPassword.invoke(user, values[0]);
                } else if (name == "gender") {
                    setGender.invoke(user, values[0]);
                } else if (name == "hobby") {
                    setHobby.invoke(user, values);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String username = user.getUsername();
        String password = user.getPassword();
        String gender = user.getGender();
        String[] hobby = user.getHobby();
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("gender = " + gender);
        System.out.println("hobby = " + hobby);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
