package com.hillel;

import com.hillel.entity.Student;
import com.hillel.service.impl.HibernateUtil;
import com.hillel.service.impl.StudentServiceImpl;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hillel.service.StudentService;

/**
 * @author Bohdan Hrytsai
 * @version 1.0.0
 *
 * @since version 1.1.0
 */

public class Main {

    private static final Logger logger = LoggerFactory.getLogger("stdout");

    public static void main(String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = new Student("Tom", "Hrytsai", 2, 1991);
        Student student1 = new Student("Bohdan", "Hrytsai", 2, 1996);
        Student student2 = new Student("Iryna", "Hrytsai", 2, 2002);

        StudentService ss = new StudentServiceImpl();
        ss.addToDataBase(session, student);
        ss.addToDataBase(session, student1);
        ss.addToDataBase(session, student2);

        ss.deleteFromDataBase(session, 3L);

        Student studentId = ss.getByIds(session, 1L);
        logger.info(String.valueOf(studentId));

        ss.getAll(session);

        ss.getByName(session, "Bohdan");

        session.close();
    }
}
