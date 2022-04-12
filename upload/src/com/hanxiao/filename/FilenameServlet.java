package com.hanxiao.filename;

import com.hanxiao.beans.User;
import com.hanxiao.util.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/filename")
public class FilenameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        if (!multipartContent) {
            response.getWriter().println("没有数据文件！");
            return;
        }
        Map<String, Object> paramsMap = FileUploadUtils.getParamsMap(request);
        User user = new User();
        try {
            BeanUtils.populate(user, paramsMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
