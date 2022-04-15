package com.hanxiao.cart;

import com.hanxiao.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.setEncoding(request, response);
        String id = request.getParameter("id");
        if (id == null|| id.isEmpty()) {
            response.getWriter().println("id为空！");
            return;
        }
        HttpSession session = request.getSession();
        List<String> history = (List<String>) session.getAttribute("history");
        if (history == null) {
//            response.getWriter().println("购物车没有记录！");
            history = new ArrayList<>();
            session.setAttribute("history", history);
        }
        history.add(id);
        response.getWriter().println("加入购物车成功！");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index");
    }
}
