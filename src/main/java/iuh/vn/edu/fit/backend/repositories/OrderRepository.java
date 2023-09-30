package iuh.vn.edu.fit.backend.repositories;

import iuh.vn.edu.fit.backend.models.Order;
import org.slf4j.LoggerFactory;

public class OrderRepository extends GenericCRUD<Order> {
    public OrderRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
}
