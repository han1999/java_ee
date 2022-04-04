package com.hanxiao.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/4
 **/

public class MainServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            while (true) {
                Socket client = serverSocket.accept();
                new Thread(() -> {
                    Request request = new Request(client);
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
