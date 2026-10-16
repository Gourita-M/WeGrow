package org.example.service;

import org.example.model.Department;
import java.util.List;

public interface DepartmentService {

    Department save(Department departement, Long userId);

    List<Department> getAll();
    
    boolean deleteById(Long id);
    
}
