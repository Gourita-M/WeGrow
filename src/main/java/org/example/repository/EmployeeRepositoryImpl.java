package org.example.repository;

import org.example.database.Database;
import org.example.model.Department;
import org.example.model.Employee;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.EntityManager;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    
    public List<Employee> getAll(){
        EntityManager em = Database.jpa();

        List<Employee> employees = em
                .createQuery(
                        "SELECT e FROM Employee e",
                        Employee.class
                )
                .getResultList();

        return employees;
    }

    public Employee create(Employee employee, Long departmentId){
        EntityManager em = Database.jpa();
        Department department = em.find(Department.class, departmentId);

        try{
            em.getTransaction().begin();
            if (department != null) {
                employee.setDepartment(department);
            }
            em.persist(employee);
            em.getTransaction().commit();

            return employee;
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }

    public Employee getById(Long id){
        EntityManager em = Database.jpa();
        try{
            Employee employee = em.find(Employee.class, id);
            //if(employee != null){
                return employee;
            //}
            
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }
}
