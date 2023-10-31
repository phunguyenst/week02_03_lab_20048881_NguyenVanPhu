package iuh.vn.edu.fit.backend.services;

import iuh.vn.edu.fit.backend.models.Customer;
import iuh.vn.edu.fit.backend.models.OrderDetail;
import iuh.vn.edu.fit.backend.repositories.EmployeeRepository;
import iuh.vn.edu.fit.backend.repositories.OrderDetailRepository;
import jakarta.inject.Inject;

import java.util.List;

public class OrderDetailServices {
    @Inject
    private OrderDetailRepository orderDetailRepository;

    public boolean add(OrderDetail orderDetail){
        return orderDetailRepository.add(orderDetail);
    }

    public List<OrderDetail> getAll(){
        return orderDetailRepository.getAll(OrderDetail.class);
    }
}
