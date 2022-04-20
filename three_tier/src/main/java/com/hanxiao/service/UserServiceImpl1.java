package com.hanxiao.service;

import com.hanxiao.dao.UserDao;
import com.hanxiao.dao.UserJsonDao;
import com.hanxiao.model.User;

import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class UserServiceImpl1 implements UserService {
    UserDao userDao = new UserJsonDao();
    @Override
    public boolean register(User registerUser) throws IOException {
        return userDao.register(registerUser);
    }

    @Override
    public int login(User loginUser) {
        return 0;
    }

    @Override
    public void function() {
        userDao.method1();
        userDao.method2();

    }
}
