package com.hanxiao.service;

import com.hanxiao.dao.UserDao;
import com.hanxiao.dao.UserSqlDao;
import com.hanxiao.model.User;

import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class UserServiceImpl2 implements UserService {
    UserDao userDao = new UserSqlDao();

    @Override
    public boolean register(User registerUser) throws IOException {
        return userDao.register(registerUser);
    }

    @Override
    public void function() {
        userDao.method2();
        userDao.method5();
    }
}
