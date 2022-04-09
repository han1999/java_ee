package com.hanxiao.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/4/8
 **/
@WebServlet("/req2")
public class RequestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        StringBuffer stringBuffer = new StringBuffer();
        String localAddr = req.getLocalAddr();
        int localPort = req.getLocalPort();

        String remoteAddr = req.getRemoteAddr();
        int remotePort = req.getRemotePort();
        stringBuffer.append("client: "+remoteAddr+":"+remotePort+
                "\nserver: "+ localAddr+":"+localPort+"\n");
        resp.getWriter().println(stringBuffer.toString());
    }
}
