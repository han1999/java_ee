package com.hanxiao.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/11
 **/

public class FileUploadUtils {
    public static Map<String, Object> getParamsMap(HttpServletRequest request) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletContext servletContext = request.getServletContext();
        File attribute = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(attribute);
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        Map<String, Object> map = new HashMap<>();
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    processFormField(fileItem, map, request);
                } else {
                    processUploadedFile(fileItem, map, request);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void processUploadedFile(FileItem fileItem, Map<String, Object> map, HttpServletRequest request) {
        String fieldName = fileItem.getFieldName();
        String name = fileItem.getName();
        name = UUID.randomUUID().toString() + name;
        String contentType = fileItem.getContentType();
        boolean inMemory = fileItem.isInMemory();
        long size = fileItem.getSize();
        System.out.println("fieldName = " + fieldName);
        System.out.println("name = " + name);
        System.out.println("contentType = " + contentType);
        System.out.println("inMemory = " + inMemory);
        System.out.println("size = " + size);
        ServletContext servletContext = request.getServletContext();
        String relativePath = fieldName + "/" + name;
        String realPath = servletContext.getRealPath(relativePath);
        File file = new File(realPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            fileItem.write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        user.setImage(relativePath);
        map.put("image", relativePath);
    }


    private static void processFormField(FileItem fileItem, Map<String, Object> map, HttpServletRequest request) throws UnsupportedEncodingException {
        String fieldName = fileItem.getFieldName();
        String string = fileItem.getString("utf-8");
        System.out.println("fieldName = " + fieldName);
        System.out.println("string = " + string);
        map.put(fieldName, string);
    }
}
