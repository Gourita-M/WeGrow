package org.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
    
    private final List<Person> users = new ArrayList<>();
    private static long nextId = 1;

    @Override
    public List<Person> findAll() {
        
        return users;
    }

    @Override
    public Optional<Person> findById(Long id) {

        return users.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    @Override
    public Person save(Person person) {

        person.setId(nextId++);
        users.add(person);
        return person;
    }

    @Override
    public boolean deleteById(Long id) {

        return users.removeIf(person ->
                person.getId() == id);
    }

    @Override
    public boolean existsByEmail(String email) {

        return users.stream()
                .anyMatch(person ->
                        person.getEmail().equalsIgnoreCase(email));
    }

}
