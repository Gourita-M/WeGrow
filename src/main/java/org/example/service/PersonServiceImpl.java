package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service 
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Person create(Person person) {
        if (repository.existsByEmail(person.getEmail())) {
            throw new IllegalArgumentException(
                    "Email already exists"
            );
        }

        return repository.save(person);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
