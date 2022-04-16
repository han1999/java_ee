package com.hanxiao.cart;

import com.hanxiao.beans.Product;
import com.hanxiao.utils.ServletUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value="/index", loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.setEncoding(request,response);
        List<Product> products = (List<Product>) getServletContext().getAttribute("products");
        for (Product product : products) {
            response.getWriter().println("<a href='" + request.getContextPath() + "/detail?id=" + product.getId() + "'>" + product.getName() + "</a>");
        }
    }

    @Override
    public void init() throws ServletException {
//        super.init(config);
        Product iphone13 = new Product("1", "iphone13", "new iphone");
        Product huawei = new Product("2", "huawei mate50", "very good");
        Product redmi_notePro10 = new Product("3", "Redmi notePro10", "good!");
        ArrayList<Product> products = new ArrayList<>();
        products.add(iphone13);
        products.add(huawei);
        products.add(redmi_notePro10);
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("products", products);
//        getServletContext().setAttribute("products", products);
    }
}
