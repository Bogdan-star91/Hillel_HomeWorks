package com.hillel.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Employee {
    @Id
    private String id;
    private String name;
    private int experience;

    @Override
    public String toString() {
        return name + '.' + experience;
    }
}
