package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private String name;
    private int experience;

    @Override
    public String toString() {
        return name + '.' + experience;
    }

}
