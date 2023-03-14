package com.hillel.service.impl;

import com.hillel.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hillel.service.StudentService;

import org.hibernate.Session;
import java.io.Serializable;
import java.util.List;

/**
 * @author Bohdan Hrytsai
 * @version 1.0.2
 *
 * @since version 1.1.0
 */
@Slf4j
public class StudentServiceImpl implements StudentService {

    private static final Logger result = LoggerFactory.getLogger("result");
    private static final Logger logger = LoggerFactory.getLogger("stdout");

    /**
     *
     * @param session SessionFactory Hibernate
     * @param student data student (Full_name, Class, Year_admission)
     *
     */
    @Override
    public void addToDataBase(Session session, Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        result.info("Object Student add to Data Base");
    }
    /**
     *
     * @param session SessionFactory Hibernate
     * @param serializable id Student
     *
     */
    @Override
    public void deleteFromDataBase(Session session, Serializable serializable) {
        session.beginTransaction();
        session.delete(session.get( Student.class, serializable ));
        session.getTransaction().commit();
        result.info("Object Student delete from Data Base");
    }

    /**
     *
     * @param session SessionFactory Hibernate
     *
     */
    @Override
    public List<Student> getAll(Session session){
        session.beginTransaction();

        String sql = "From " + Student.class.getSimpleName();
        logger.info("sql = " + sql);

        List<Student> students = session.createQuery(sql).list();

        logger.info("students.size = " + students.size());
        for (Student student : students) {
            logger.info(student.toString());
        }

        session.getTransaction().commit();
        return students;
    }

    /**
     *
     * @param session SessionFactory Hibernate
     * @param name full name student
     *
     */
    @Override
    public List<Student> getByName(Session session, String name){
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Student.class)
                .add(Restrictions.eq("name", name));
        List<Student> students = criteria.list();

        for (Student student : students) {
            logger.info(student.toString());
        }
        session.getTransaction().commit();
        return students;
    }

    /**
     *
     * @param session vSessionFactory Hibernate
     * @param serializable id Student
     *
     */
    @Override
    public Student getByIds(Session session, Serializable serializable){
        session.beginTransaction();
        Student student;
        student = (Student) session.get(Student.class,serializable );
        session.getTransaction().commit();

        return student;
    }
}
