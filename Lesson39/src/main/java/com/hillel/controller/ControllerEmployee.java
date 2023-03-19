package com.hillel.controller;

import com.hillel.repository.RepositoryLoyaltyList;
import com.hillel.service.ServiceEmployee;
import lombok.RequiredArgsConstructor;
import com.hillel.model.Employee;
import com.hillel.repository.RepositoryEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class ControllerEmployee {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final RepositoryEmployee repositoryEmployee;

    private final ServiceEmployee serviceEmployee;

    private final RepositoryLoyaltyList repositoryLoyaltyList;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee addNewEmployee(@RequestBody Employee employee) {
        LOG.info("Saving employee");
        return repositoryEmployee.save(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return serviceEmployee.getAllEmployees();
    }


}
