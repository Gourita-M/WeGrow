package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.model.Person;

public interface PersonService {
    
    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person create(Person person);

    boolean deleteById(Long id);

}
