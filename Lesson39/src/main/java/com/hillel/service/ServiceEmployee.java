package com.hillel.service;


import com.hillel.model.Employee;

import java.util.List;

public interface ServiceEmployee {

    void saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

}
