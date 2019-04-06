package com.guevarak1.cassandrademo.api;

import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {
    private String title;
    private String publisher;
    private Set<String> tags;
}
