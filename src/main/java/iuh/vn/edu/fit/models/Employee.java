package iuh.vn.edu.fit.models;

import iuh.vn.edu.fit.enums.EmployeeStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    //employee (emp_id, full_name, dob, email, phone, address, status)
    @Id
    @Column(name = "emp_id", columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;
    @Column(columnDefinition = "datetime(6)")
    private LocalDateTime dob;

    private String email;

    @Column(columnDefinition = "varchar(15)")
    private String phone;

    private String address;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int")
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(long id, String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }





    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
