package com.hanxiao.service;

import com.hanxiao.dao.UserDao;
import com.hanxiao.dao.UserSqlDbutilsDao;
import com.hanxiao.model.User;

import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class UserServiceImpl2 implements UserService {
//    UserDao userDao = new UserSqlDao();
    UserDao userDao = new UserSqlDbutilsDao();

    @Override
    public boolean register(User registerUser) throws IOException {
        return userDao.register(registerUser);
    }

    @Override
    public int login(User loginUser) {
        return userDao.login(loginUser);
    }

    @Override
    public void function() {
        userDao.method2();
        userDao.method5();
    }
}
