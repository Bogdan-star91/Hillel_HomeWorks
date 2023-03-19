package com.hillel.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class BonusLoyalty {

    @Id
    private String id;
    private String employees;

    @Override
    public String toString() {

        return employees.getClass().getName() + ", ";
    }
}

