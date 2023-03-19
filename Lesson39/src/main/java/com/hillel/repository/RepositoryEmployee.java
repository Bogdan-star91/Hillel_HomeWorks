package com.hillel.repository;

import com.hillel.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmployee extends MongoRepository<Employee, String> {
}
