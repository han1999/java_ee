package com.hanxiao.dao;

import com.hanxiao.model.User;
import com.hanxiao.utils.Constant;

import java.sql.*;

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
    public int login(User loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_ee",
                    "root", "123456");
            preparedStatement = connection.prepareStatement("select * from users where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Constant.LOGIN_SUCCESS;
            } else {
                return Constant.LOGIN_FAIL;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            if (connection != null) {
                                try {
                                    connection.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        return Constant.LOGIN_ERROR;
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
