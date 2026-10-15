package org.example.controller;

import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService service) {
        this.personService = service;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(
            @PathVariable("id") Long id) {

        return personService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody Person person) {

        try {
            Person created = personService.create(person);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(created);

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Long id) {

        if (personService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
