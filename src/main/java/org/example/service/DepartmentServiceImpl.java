package org.example.service;

import org.example.model.Department;
import org.example.repository.DepartmentRepository;
import org.example.repository.DepartmentRepositoryImpl;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    
    @Override 
    public Department save(Department departement){
        return departmentRepository.save(departement);
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
