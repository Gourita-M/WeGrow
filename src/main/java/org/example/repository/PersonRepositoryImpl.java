package org.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.model.*;

public class PersonRepositoryImpl implements PersonRepository{
    private final List<Person> users = new ArrayList<>();
    private int nextId;

    @Override
    public synchronized List<Person> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public synchronized Optional<Person> findById(Long id) {
        return users.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public synchronized Person save(Person person) {
        person.setId(nextId.getAndIncrement());
        users.add(person);
        return person;
    }

    @Override
    public synchronized boolean deleteById(Long id) {
        return users.removeIf(person ->
                person.getId().equals(id));
    }

    @Override
    public synchronized boolean existsByEmail(String email) {
        return users.stream()
                .anyMatch(person ->
                        person.getEmail().equalsIgnoreCase(email));
    }

}
