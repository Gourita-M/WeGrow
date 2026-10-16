package org.example.repository;

import org.example.model.Department;
import java.util.List;

public interface DepartmentRepository {
    
    Department save(Department departement, Long userId);

    List<Department> getAll();

    boolean deleteById(Long id);

}
