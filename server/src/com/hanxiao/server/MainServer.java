package com.hanxiao.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
                    String requestURI = request.getRequestURI();
                    File file = new File(requestURI.substring(1));
                    OutputStream outputStream = null;
                    try {
                        outputStream = client.getOutputStream();
                        StringBuffer stringBuffer = new StringBuffer();
                        if (file.exists() && file.isFile()) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            stringBuffer.append("HTTP/1.1 200 OK\r\n");
                            stringBuffer.append("Content-Type:text/html\r\n");
                            stringBuffer.append("\r\n");
                            outputStream.write(stringBuffer.toString().getBytes("utf8"));
                            int length = 0;
                            byte[] bytes = new byte[1024];
                            while ((length = fileInputStream.read(bytes)) != -1) {
                                outputStream.write(bytes, 0, length);
                            }
                        } else {
                            stringBuffer.append("HTTP/1.1 404 Not Found\r\n");
                            stringBuffer.append("Content-Type:text/html\r\n");
                            stringBuffer.append("\r\n");
                            stringBuffer.append("<div style='color:red'>File Not Found</div>");
                            outputStream.write(stringBuffer.toString().getBytes("utf8"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
