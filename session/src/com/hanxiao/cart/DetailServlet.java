package com.hanxiao.cart;

import com.hanxiao.beans.Product;
import com.hanxiao.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.setEncoding(request, response);
        String id = request.getParameter("id");
        if (id == null || "".equals(id.trim())) {
            response.getWriter().println("id参数不能为空！");
            return;
        }
        List<Product> products = (List<Product>) getServletContext().getAttribute("products");
        for (Product product : products) {
            if (id.equals(product.getId())) {
                response.getWriter().println(product);
            }
        }
        response.getWriter().println("<a href='"+request.getContextPath()+"/index"+"'>返回首页</a>");
        response.getWriter().println("<a href='"+request.getContextPath()+"/addCart?id="+id+"'>加入购物车</a>");
        response.getWriter().println("<a href='"+request.getContextPath()+"/viewCart"+"'>查看购物车</a>");

    }
}
