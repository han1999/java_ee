package com.hanxiao.upload;

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
import java.util.List;

@WebServlet("/upload2")
public class UploadServlet2 extends HttpServlet {
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
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    processFormField(fileItem);
                } else {
                    processUploadedFile(fileItem);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    private void processUploadedFile(FileItem fileItem) {
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
        String realPath = servletContext.getRealPath(fieldName + "/" + name);
        File file = new File(realPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            fileItem.write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processFormField(FileItem fileItem) {
        String fieldName = fileItem.getFieldName();
        String string = fileItem.getString();
        System.out.println("fieldName = " + fieldName);
        System.out.println("string = " + string);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
