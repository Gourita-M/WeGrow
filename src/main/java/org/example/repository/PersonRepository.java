package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.model.Person;
import org.springframework.stereotype.Repository;

public interface PersonRepository {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person person);

    boolean deleteById(Long id);

    boolean existsByEmail(String email);
}
