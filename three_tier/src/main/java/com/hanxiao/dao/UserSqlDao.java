package com.hanxiao.dao;

import com.hanxiao.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class UserSqlDao implements UserDao {

    @Override
    public boolean register(User registerUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_ee",
                    "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(null, ?, ?)");
            preparedStatement.setString(1, registerUser.getUsername());
            preparedStatement.setString(2, registerUser.getPassword());
            int i = preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
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
