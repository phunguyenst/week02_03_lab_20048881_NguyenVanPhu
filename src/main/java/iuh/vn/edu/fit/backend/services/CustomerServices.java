package iuh.vn.edu.fit.backend.services;

import iuh.vn.edu.fit.backend.models.Customer;
import iuh.vn.edu.fit.backend.repositories.CustomerRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class CustomerServices {
    @Inject
    private CustomerRepository customerRepository;

    @Inject
    public CustomerServices() {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.getCustomerById(id);
    }
    public boolean add(Customer customer){
        return customerRepository.add(customer);
    }

    public boolean update(Customer customer){
        return customerRepository.update(customer);
    }
    public boolean remove(long id){
        return customerRepository.remove(Customer.class,id);
    }

    public List<Customer> getAll(){
        return customerRepository.getAll(Customer.class);
    }
}
