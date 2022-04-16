package com.hanxiao.pattern;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/16
 **/

public class Main {
    public static void main(String[] args) {
        Baby baby = new Baby();
        baby.add(new Dad());
        baby.add(new Grandma());
        baby.add(new Grandma());
        baby.add(new Mom());
        baby.cry();
    }
}
