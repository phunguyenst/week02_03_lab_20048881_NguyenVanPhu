package iuh.vn.edu.fit.backend.repositories;


import iuh.vn.edu.fit.backend.enums.EmployeeStatus;
import iuh.vn.edu.fit.backend.models.Employee;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class EmployeeRepository extends  GenericCRUD<Employee> {
    public EmployeeRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public void setStatus(Employee employee, EmployeeStatus status){
        employee.setStatus(status);
    }

    public Optional<Employee> getEmployeeById(long id){
        try {
            return Optional.of(em.find(Employee.class, id));
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }



}
