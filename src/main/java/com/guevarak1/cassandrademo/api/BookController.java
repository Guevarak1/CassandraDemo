package com.guevarak1.cassandrademo.api;

import com.guevarak1.cassandrademo.repository.models.Book;
import com.guevarak1.cassandrademo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//https://www.tutorialspoint.com/cassandra/cassandra_create_keyspace.htm
@RestController
@RequestMapping(value = "/books", produces = "application/json")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> retrieveBookById(@PathVariable UUID id) {
        return new ResponseEntity<>(bookService.retrieveBook(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookDTO book) {
        Book newBook = bookService.createBook(book.getTitle(), book.getPublisher(), book.getTags());
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> updateBookPublisher(@PathVariable UUID id, @RequestBody BookDTO book){
        Book updatedBook = bookService.updateBookPublisher(id, book.getPublisher());
        return new ResponseEntity<>(updatedBook, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> retrieveAllBooks() {
        return new ResponseEntity<>(bookService.retrieveAllBooks(), HttpStatus.OK);
    }

}
