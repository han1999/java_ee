package com.hanxiao;

import java.util.Scanner;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/9
 **/

public class StringTest {
    public static void main(String[] args) {
        String name="username";
        System.out.println("username"==name);
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        //at runtime, though name's value is username, the result is also false
        //however, if we define name as username, (before runtime), the result is true;
        System.out.println("username"==name);
    }
}
