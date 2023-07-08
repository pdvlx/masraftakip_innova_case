package com.innovacase.controllers;

import com.innovacase.models.Person;
import com.innovacase.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create/")
    public Person createPerson( @RequestBody Person person) {

        return personService.savePerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable(value = "id") Long personId) {
        return personService.getPersonById(personId);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable(value = "id") Long personId,@RequestBody Person personDetails) {
        return personService.updatePerson(personId, personDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.ok().build();
    }
}