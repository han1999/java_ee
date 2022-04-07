package com.hanxiao.server.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/7
 **/

public class MainTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.hanxiao.server.reflection.Student");
        Object o = aClass.newInstance();
        Method say = aClass.getDeclaredMethod("say");
        say.invoke(o);
    }
}
