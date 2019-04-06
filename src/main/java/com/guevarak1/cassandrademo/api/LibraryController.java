package com.guevarak1.cassandrademo.api;

import com.guevarak1.cassandrademo.config.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/library", produces = "application/json")
public class LibraryController {

    //is book available
    //is book checked out
    //checkout book
    //requests for book

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    private Sender sender;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody String message) {
        sender.send(message);
        return new ResponseEntity<>("send message", HttpStatus.CREATED);
    }
}
