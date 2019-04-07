package com.guevarak1.cassandrademo.repository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Table
@Data
@AllArgsConstructor
public class Book {
    @PrimaryKey
    @PrimaryKeyColumn(
            name = "isbn",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING)
    private UUID isbn;
    @Column
    private String title;
    @Column
    private String publisher;
    @Column
    private Set<String> tags;

}

//cqlsh
//use testkeyspace;
//CREATE TABLE book(
//   isbn UUID PRIMARY KEY,
//   title text,
//   publisher text,
//   tags set<text>
//   );