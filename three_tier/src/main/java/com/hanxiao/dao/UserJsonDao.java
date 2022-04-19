package com.hanxiao.dao;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hanxiao.controller.MVCRegisterServlet;
import com.hanxiao.model.User;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class UserJsonDao  implements  UserDao{
    @Override
    public boolean register(User registerUser) throws IOException {
        ClassLoader classLoader = MVCRegisterServlet.class.getClassLoader();
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
        String registerUsername = registerUser.getUsername();
        for (JsonElement element : jsonArray) {
            User user = gson.fromJson(element, User.class);
            String nowUsername = user.getUsername();
            if (registerUsername.equals(nowUsername)) {
                return false;
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
        return true;
    }

    @Override
    public int login(User loginUser) {
        return 0;
    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {

    }

    @Override
    public void method5() {

    }
}
