package com.guevarak1.cassandrademo.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@PrimaryKeyClass
@Data
@AllArgsConstructor
public class PersonKey implements Serializable{
    /*
    Partitioned: determines data locality
     */
    @PrimaryKeyColumn(name = "first_name", type = PrimaryKeyType.PARTITIONED)
    private String firstName;

    /*
    Ordinal: determines the ordering in which columns get created
     */
    @PrimaryKeyColumn(name = "date_of_birth", ordinal = 0)
    private LocalDateTime dateOfBirth;

    @PrimaryKeyColumn(name = "person_id", ordinal = 1, ordering = Ordering.DESCENDING)
    private UUID id;

    public PersonKey(UUID id) {
        this.id = id;
    }
}
