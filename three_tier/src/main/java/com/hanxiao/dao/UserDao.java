package com.hanxiao.dao;

import com.hanxiao.model.User;

import java.io.IOException;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/4/18
 **/
public interface UserDao {
    boolean register(User registerUser) throws IOException;

    int login(User loginUser);

    void method1();

    void method2();

    void method3();

    void method4();

    void method5();
}
