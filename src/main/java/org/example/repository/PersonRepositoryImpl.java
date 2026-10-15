package org.example.repository;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.model.Person;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.database.Database;

@Repository
public class PersonRepositoryImpl implements PersonRepository{


    @Override
    public List<Person> findAll() {

        EntityManager entityManager = Database.jpa();

        List<Person> users = entityManager
                .createQuery(
                        "SELECT p FROM Person p",
                        Person.class
                )
                .getResultList();

        return users;

    }

    @Override
    public Optional<Person> findById(Long id) {
        Person person;
        EntityManager entityManager = Database.jpa();

        try{
            person = entityManager.find(Person.class, id);
        }catch (RuntimeException e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            throw e;

        }finally{
            entityManager.close();
        }

        return Optional.ofNullable(person);
    }

    @Override
    public Person save(Person person) {

        EntityManager entityManager = Database.jpa();
        try{

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        }catch (RuntimeException e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            throw e;
            
        }finally{
            entityManager.close();
        }
        return person;
    }

    @Override
    public boolean deleteById(Long id) {

            EntityManager entityManager = Database.jpa();

        try {
            entityManager.getTransaction().begin();

            Person person = entityManager.find(Person.class, id);

            if (person == null) {
                entityManager.getTransaction().rollback();
                return false;
            }

            entityManager.remove(person);

            entityManager.getTransaction().commit();

            return true;

        } catch (RuntimeException e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            throw e;

        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        
        List<Person> users = findAll();
        
        return users.stream()
        .anyMatch(u -> u.getEmail().equals(email));

    }

}
