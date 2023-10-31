package iuh.vn.edu.fit.backend.services;

import iuh.vn.edu.fit.backend.models.Order;
import iuh.vn.edu.fit.backend.models.OrderDetail;
import iuh.vn.edu.fit.backend.repositories.OrderDetailRepository;
import iuh.vn.edu.fit.backend.repositories.OrderRepository;
import jakarta.inject.Inject;

import java.util.List;

public class OrderServices {
    @Inject
    private OrderRepository orderRepository;
    public boolean add(Order order){
        return orderRepository.add(order);
    }

    public List<Order> getAll(){
        return orderRepository.getAll(Order.class);
    }
}
