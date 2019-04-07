package com.guevarak1.cassandrademo.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

//in cassandra, you think of the tables as queries.
@Table("people_by_first_name")
@AllArgsConstructor
@Data
public class Person {
    @PrimaryKey
    private PersonKey key;

    @Column("last_name")
    private String lastName;

    @Column
    private int booksCheckedOut;
}
