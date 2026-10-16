package org.example.repository;

import org.example.model.Employee;
import java.util.List;

public interface EmployeeRepository {
    
    List<Employee> getAll();
    Employee create(Employee employee);
    Employee getById(Long id);
}
