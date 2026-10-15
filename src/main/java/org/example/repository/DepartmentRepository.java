package org.example.repository;

import org.example.model.Department;
import java.util.List;

public interface DepartmentRepository {
    
    Department save(Department departement);

    List<Department> getAll();
    
    boolean deleteById(Long id);

}
