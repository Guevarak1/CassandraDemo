package com.guevarak1.cassandrademo.repository;

import com.guevarak1.cassandrademo.service.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends CassandraRepository<Book, UUID> {
}
