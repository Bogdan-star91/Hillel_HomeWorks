package com.hillel.service;


import com.hillel.entity.Student;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface StudentService {
    void addToDataBase(Session session, Student student);

    void deleteFromDataBase(Session session, Serializable serializable);

    List<Student> getAll(Session session);

    List<Student> getByName(Session session, String name);

    Student getByIds(Session session, Serializable serializable);
}
