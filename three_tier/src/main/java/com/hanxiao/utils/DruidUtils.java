package com.hanxiao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/19
 **/

public class DruidUtils {
    public static DataSource dataSource;

    static {
        ClassLoader classLoader = DruidUtils.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
