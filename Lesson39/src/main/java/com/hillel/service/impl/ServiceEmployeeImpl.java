package com.hillel.service.impl;

import com.hillel.service.ServiceEmployee;
import lombok.RequiredArgsConstructor;
import com.hillel.model.Employee;
import com.hillel.repository.RepositoryEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final RepositoryEmployee repositoryEmployee;

    @Override
    public void saveEmployee(Employee employee) {
        repositoryEmployee.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repositoryEmployee.findAll().stream().toList();
    }
}
