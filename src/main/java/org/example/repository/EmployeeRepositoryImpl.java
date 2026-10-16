package org.example.repository;

import org.example.database.Database;
import org.example.model.Employee;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.EntityManager;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    
    public List<Employee> getAll(){
        EntityManager em = Database.jpa();
        try{
            em.getTransaction().begin();
            List<Employee> employee = new ArrayList<>();
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

    public Employee create(Employee employee){
        EntityManager em = Database.jpa();
        try{
            em.getTransaction().begin();
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
