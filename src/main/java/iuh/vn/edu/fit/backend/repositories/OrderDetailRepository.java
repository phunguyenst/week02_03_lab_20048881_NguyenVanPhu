package iuh.vn.edu.fit.backend.repositories;

import iuh.vn.edu.fit.backend.models.OrderDetail;
import org.slf4j.LoggerFactory;

public class OrderDetailRepository extends GenericCRUD<OrderDetail> {
    public OrderDetailRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
}
