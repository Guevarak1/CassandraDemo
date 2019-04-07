package com.guevarak1.cassandrademo.api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonDto {
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
}
