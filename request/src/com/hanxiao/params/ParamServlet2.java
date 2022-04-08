package com.hanxiao.params;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/param2")
public class ParamServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuffer stringBuffer = new StringBuffer();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
//            String parameter = request.getParameter(s);
            String[] parameterValues = request.getParameterValues(s);
            stringBuffer.append(s+":"+ Arrays.toString(parameterValues) +"\n");
        }
        response.getWriter().println(stringBuffer.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuffer stringBuffer = new StringBuffer();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(s);
            stringBuffer.append(s+":"+ Arrays.toString(parameterValues) +"\n");
        }
        response.getWriter().println(stringBuffer.toString());
    }
}
