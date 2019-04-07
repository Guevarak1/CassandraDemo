package com.guevarak1.cassandrademo.api;

import com.guevarak1.cassandrademo.repository.models.Person;
import com.guevarak1.cassandrademo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person", produces = "application/json")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody PersonDto person) {
        Person newBook = personService.createNewPerson(person.getFirstName(), person.getLastName(), person.getDateOfBirth());
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
}
