package com.hanxiao.util;

import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/9
 **/

public class ReflectionUtils {
    public static final String PREFIX = "set";

    public static void toBean(Object o, Map<String, String[]> parameterMap) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = o.getClass();
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            String[] values = parameterMap.get(name);
            Field declaredField = aClass.getDeclaredField(name);
            Method declaredMethod = aClass.getDeclaredMethod(PREFIX + StringUtils.capitalize(name), declaredField.getType());
            String simpleName = declaredField.getType().getSimpleName();
            if ("String".equals(simpleName)) {
                declaredMethod.invoke(o, values[0]);
            } else if ("String[]".equals(simpleName)) {
                declaredMethod.invoke(o, (Object) values);
            }
        }
    }
}
