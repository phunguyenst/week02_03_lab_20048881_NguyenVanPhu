package iuh.vn.edu.fit.frontend.controllers;

import iuh.vn.edu.fit.backend.models.Cart;
import iuh.vn.edu.fit.backend.models.Order;
import iuh.vn.edu.fit.backend.models.OrderDetail;
import iuh.vn.edu.fit.backend.models.Product;
import iuh.vn.edu.fit.backend.services.OrderDetailServices;
import iuh.vn.edu.fit.backend.services.OrderServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/order-now")
public class OrderServlet extends HttpServlet {
    private OrderServices orderService;
    private OrderDetailServices orderDetailService;

    public void init() {
        orderService = new OrderServices(); // Initialize your OrderService
        orderDetailService = new OrderDetailServices(); // Initialize your OrderDetailService
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(PrintWriter out =resp.getWriter()){
            out.print("this buy now servlet");
        }
        String productId = req.getParameter("id");
        double quantity = Double.parseDouble(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        Product product = new Product(); // Assuming product creation using productId

        LocalDateTime orderDate = LocalDateTime.now();

        Order order = new Order( /* provide required arguments */);

        OrderDetail orderDetail = new OrderDetail(order, product, quantity, price, "Additional note");

        boolean result = orderService.add(order);
        orderDetailService.add(orderDetail);

        List<Order> orders = orderService.getAll();
        req.setAttribute("orders", orders);
        if(result){
            ArrayList<Cart> carts = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");
            if(carts != null){
                for (Cart c: carts){
                    if(c.getId() == Long.parseLong(productId)){
                        carts.remove(carts.indexOf(c));
                    }
                }
                resp.sendRedirect("cart.jsp");
            }

        }
        resp.sendRedirect("orders.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
