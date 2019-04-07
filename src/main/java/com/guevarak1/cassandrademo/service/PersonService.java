package com.guevarak1.cassandrademo.service;

import com.datastax.driver.core.utils.UUIDs;
import com.guevarak1.cassandrademo.repository.PersonRepository;
import com.guevarak1.cassandrademo.repository.models.Person;
import com.guevarak1.cassandrademo.repository.models.PersonKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createNewPerson (String firstName, String lastName, LocalDateTime dateOfBirth) {
        PersonKey key = new PersonKey(firstName, dateOfBirth, UUIDs.timeBased());
        Person person = new Person(key, lastName, 0);
        return personRepository.save(person);
    }
}
