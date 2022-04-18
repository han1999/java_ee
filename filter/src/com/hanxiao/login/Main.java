package com.hanxiao.login;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/17
 **/

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Product.price=1;
        product.price=5;
        System.out.println("Product.price = " + Product.price);
    }
}
