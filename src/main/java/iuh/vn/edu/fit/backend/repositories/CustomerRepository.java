package iuh.vn.edu.fit.backend.repositories;

import iuh.vn.edu.fit.backend.models.Customer;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository extends GenericCRUD<Customer> {

    public CustomerRepository() {
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public Optional<Customer> getCustomerById(long id){
        try {
            return Optional.of(em.find(Customer.class, id));
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

        List<Customer> customerList = customerRepository.getAll(Customer.class);
        for (Customer cus: customerList

             ) {
            System.out.println(cus);

        }
    }
}
