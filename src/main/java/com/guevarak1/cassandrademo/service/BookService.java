package com.guevarak1.cassandrademo.service;

import com.datastax.driver.core.utils.UUIDs;
import com.guevarak1.cassandrademo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book retrieveBook(UUID id) {
        return bookRepository.findById(id).get();
    }

    public Book createBook(String title, String publisher, Set<String> tags) {
        Book newBook = new Book(UUIDs.timeBased(), title, publisher, tags);
        return bookRepository.save(newBook);
    }

    public Book updateBookPublisher(UUID id, String publisher) {
        Book book = bookRepository.findById(id).get();
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

    public List<Book> retrieveAllBooks(){
        return bookRepository.findAll();
    }
}
