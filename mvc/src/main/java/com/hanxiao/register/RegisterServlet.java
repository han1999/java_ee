package com.hanxiao.register;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hanxiao.beans.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

//@WebServlet("/user/*")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = (String) request.getAttribute("action");
        if ("register".equals(action)) {
            register(request, response);
        }
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
        ClassLoader classLoader = RegisterServlet.class.getClassLoader();
        URL resource = classLoader.getResource("users.json");
        String path = resource.getPath();
        System.out.println("path = " + path);
//        InputStream resourceAsStream = classLoader.getResourceAsStream("users.json");
        FileInputStream fileInputStream = new FileInputStream(path);
        int len=0;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = fileInputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        String jsonStr = byteArrayOutputStream.toString();
        Gson gson = new Gson();
        JsonElement jsonElement = JsonParser.parseString(jsonStr);
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        ArrayList<User> users = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            User user = gson.fromJson(element, User.class);
            String nowUsername = user.getUsername();
            if (username.equals(nowUsername)) {
                response.getWriter().println("用户已存在，请登录！");
                response.setHeader("refresh", "1;url=" + request.getContextPath()+"/login.html");
                return;
            }
            users.add(user);
        }
        users.add(registerUser);
        String toJson = gson.toJson(users);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(toJson.getBytes());
        byteArrayOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
        response.getWriter().println("注册成功！请登录！");
        response.setHeader("refresh", "1;url="+ request.getContextPath()+"/login.html");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
