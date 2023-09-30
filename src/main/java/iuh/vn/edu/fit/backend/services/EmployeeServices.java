package iuh.vn.edu.fit.backend.services;


import iuh.vn.edu.fit.backend.models.Employee;
import iuh.vn.edu.fit.backend.repositories.EmployeeRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    @Inject
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(long id){
        return employeeRepository.getEmployeeById(id);
    }
    public boolean add(Employee customer){
        return employeeRepository.add(customer);
    }

    public boolean update(Employee customer){
        return employeeRepository.update(customer);
    }
    public boolean remove(long id){
        return employeeRepository.remove(Employee.class,id);
    }

    public List<Employee> getAll(){
        return  employeeRepository.getAll(Employee.class);
    }
}
