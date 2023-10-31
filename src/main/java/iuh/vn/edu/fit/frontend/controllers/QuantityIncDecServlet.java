package iuh.vn.edu.fit.frontend.controllers;

import iuh.vn.edu.fit.backend.models.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter();){
            String action = req.getParameter("action");
            long id = Long.parseLong(req.getParameter("id"));
            HttpSession session = req.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            System.out.println(cart_list);
            if(action != null){
                if (action.equals("inc")){
                    for (Cart c: cart_list){
                        if(c.getId() == id){
                            int quatity = c.getQuantity();
                            quatity++;
                            c.setQuantity(quatity);
                            resp.sendRedirect("cart.jsp");
                        }
                    }
                }
                if (action.equals("dec")){
                    for (Cart c: cart_list){
                        if(c.getId() == id && c.getQuantity() > 1){
                            int quatity = c.getQuantity();
                            quatity--;
                            c.setQuantity(quatity);
                            resp.sendRedirect("cart.jsp");
                        }
                    }
                }

            }
            else{
                resp.sendRedirect("cart.jsp");
            }

        }
    }
}
