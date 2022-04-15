package com.hanxiao.cart;

import com.hanxiao.beans.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product iphone13 = new Product("1", "iphone13", "new iphone");
        Product huawei = new Product("2", "huawei mate50", "very good");
        Product redmi_notePro10 = new Product("3", "Redmi notePro10", "good!");
        ArrayList<Product> products = new ArrayList<>();
        products.add(iphone13);
        products.add(huawei);
        products.add(redmi_notePro10);
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        for (Product product : products) {
            response.getWriter().println("<a href='" + request.getContextPath() + "/detail?id=" + product.getId() + "'>" + product.getName() + "</a>");
        }
    }
}
