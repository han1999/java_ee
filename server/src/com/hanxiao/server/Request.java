package com.hanxiao.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/4
 **/

public class Request {
    private InputStream inputStream;
    private String requestMessage;
    private String method;
    private String requestURI;
    private String protocol;

    private Map<String, String> requestHeaders = new HashMap<>();

    public Request(Socket client) {
        try {
            this.inputStream = client.getInputStream();
            parseRequest();
            parseRequestLine();
            parseRequestHeader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRequestHeader() {
        int begin = requestMessage.indexOf("\r\n");
        int end = requestMessage.indexOf("\r\n\r\n");
        String substring = requestMessage.substring(begin + 2, end);
        String[] parts = substring.split("\r\n");
        for (String part : parts) {
            int i = part.indexOf(":");
            String key = part.substring(0, i).trim();
            String value = part.substring(i + 1).trim();
            requestHeaders.put(key, value);
        }
    }

    private void parseRequestLine() {
        int i = requestMessage.indexOf("\r\n");
        String requestLine = requestMessage.substring(0, i);
        String[] parts = requestLine.split(" ");
        method = parts[0];
        requestURI = parts[1];
        protocol = parts[2];
        int i1 = requestURI.indexOf("?");
        if (i1 != -1) {
            requestURI = requestURI.substring(0, i1);
        }
    }

    private void parseRequest() throws IOException {
        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);
        requestMessage = new String(bytes, 0, length);
        System.out.println(requestMessage);
    }
}
