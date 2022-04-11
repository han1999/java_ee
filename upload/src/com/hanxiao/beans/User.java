package com.hanxiao.beans;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/11
 **/

public class User {
    private String username;
    private  String password;
    private  String image;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User() {
    }
}
