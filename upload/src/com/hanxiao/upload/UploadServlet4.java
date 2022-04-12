package com.hanxiao.upload;

import com.hanxiao.beans.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/upload4")
public class UploadServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if (!multipartContent) {
            response.getWriter().println("没有上传文件！");
            return;
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletContext servletContext = getServletContext();
        File attribute = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(attribute);

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
//        upload.setSizeMax(1024);
        User user = new User();
        Map<String, Object> map=new HashMap<>();
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    processFormField(fileItem,map);
                } else {
                    processUploadedFile(fileItem,map);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
    }

    private void processUploadedFile(FileItem fileItem, Map<String, Object> map) {
        String fieldName = fileItem.getFieldName();
        String name = fileItem.getName();
        String contentType = fileItem.getContentType();
        boolean inMemory = fileItem.isInMemory();
        long size = fileItem.getSize();
        System.out.println("fieldName = " + fieldName);
        System.out.println("name = " + name);
        System.out.println("contentType = " + contentType);
        System.out.println("inMemory = " + inMemory);
        System.out.println("size = " + size);
        ServletContext servletContext = getServletContext();
        String relativePath=fieldName+"/"+name;
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


    private void processFormField(FileItem fileItem, Map<String, Object> map) throws UnsupportedEncodingException {
        String fieldName = fileItem.getFieldName();
        String string = fileItem.getString("utf-8");
        System.out.println("fieldName = " + fieldName);
        System.out.println("string = " + string);
        map.put(fieldName, string);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
