package com.hanxiao.dao;

import com.hanxiao.model.User;
import com.hanxiao.utils.Constant;
import com.hanxiao.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.*;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/18
 **/

public class UserSqlDbutilsDao implements UserDao {

    @Override
    public boolean register(User registerUser) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("insert into users values(null, ?, ?)", registerUser.getUsername(), registerUser.getPassword());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int login(User loginUser) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            User user = queryRunner.query("select * from users where username=? and password=?",
                    new BeanHandler<>(User.class), loginUser.getUsername(), loginUser.getPassword());
            if (user == null) {
                return Constant.LOGIN_FAIL;
            } else {
                return Constant.LOGIN_SUCCESS;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
