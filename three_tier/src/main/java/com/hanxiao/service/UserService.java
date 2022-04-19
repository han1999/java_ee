package com.hanxiao.service;

import com.hanxiao.model.User;

import java.io.IOException;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/4/18
 **/
public interface UserService {
    boolean register(User registerUser) throws IOException;

    void function();
}
