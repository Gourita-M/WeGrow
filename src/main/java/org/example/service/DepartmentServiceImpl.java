package org.example.service;

import org.example.model.Department;
import org.example.repository.DepartmentRepository;
import org.example.repository.DepartmentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    
    @Override 
    public Department save(Department departement, Long userId){
        return departmentRepository.save(departement, userId);
    }

    @Override 
    public List<Department> getAll(){
        return departmentRepository.getAll();
    }
    
    @Override 
    public boolean deleteById(Long id){
        return departmentRepository.deleteById(id);
    }
}
