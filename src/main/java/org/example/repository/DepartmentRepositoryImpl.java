package org.example.repository;

import java.util.List;
import java.util.ArrayList;

import org.example.model.Department;
import org.example.database.Database;
import jakarta.persistence.EntityManager;

public class DepartmentRepositoryImpl implements DepartmentRepository{

    @Override
    public Department save(Department departement){
        EntityManager entityManager = Database.jpa();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(departement);
            entityManager.getTransaction().commit();

            return departement;
        }catch(Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw e;
        }finally{
            entityManager.close();
        }
        
    }

    @Override
    public List<Department> getAll(){
        EntityManager entityManager = Database.jpa();

        List<Department> department = entityManager
                .createQuery(
                        "SELECT p FROM Department p",
                        Department.class
                )
                .getResultList();

        return department;
    }

    @Override
    public boolean deleteById(Long id){

        EntityManager entityManager = Database.jpa();
        Department department = entityManager.find(Department.class, id);
        
        try{
            entityManager.getTransaction().begin();
            if(department != null){
                entityManager.remove(department);
            }
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
        }finally{
            entityManager.close();
        }
        return false;
    }
}
