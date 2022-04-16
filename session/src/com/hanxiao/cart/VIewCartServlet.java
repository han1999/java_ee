package com.hanxiao.cart;

import com.hanxiao.beans.Product;
import com.hanxiao.utils.ServletUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewCart")
public class VIewCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.setEncoding(request, response);
        HttpSession session = request.getSession();
        List<String> history = (List<String>) session.getAttribute("history");
        if (history == null) {
            response.getWriter().println("购物车为空！快点去买东西！");
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index");
            return;
        }
        ServletContext servletContext = getServletContext();
        List<Product> products = (List<Product>) servletContext.getAttribute("products");
        for (String id : history) {
            for (Product product : products) {
                if (id.equals(product.getId())) {
                    response.getWriter().println(product);
                }
            }
        }
        response.getWriter().println("<a href='"+request.getContextPath()+"/index"+"'>返回首页</a>");
    }
}
