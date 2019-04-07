package com.guevarak1.cassandrademo.repository;

import com.guevarak1.cassandrademo.repository.models.Person;
import com.guevarak1.cassandrademo.repository.models.PersonKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

//https://lankydanblog.com/2017/10/22/separate-keyspaces-with-spring-data-cassandra/
@Repository
public interface PersonRepository extends CassandraRepository<Person, PersonKey>{

    List<Person> findByKeyFirstName(String firstName);

    //SELECT * FROM people_by_first_name WHERE first_name = [firstName input] and date_of_birth > [dateOfBirth input];
    List<Person> findByKeyFirstNameAndKeyDateOfBirthGreaterThan(
            String firstName, LocalDateTime dateOfBirth);

    /*
    Allow filtering is needed to query fields that are not part of the primary key
    not recommended because it requires the whole table to be read and then goes out and filters out invalid records
     */
    @Query(allowFiltering = true)
    List<Person> findByLastName(final String lastName);
}
