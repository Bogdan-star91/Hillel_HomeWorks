package service.impl;

import dto.Student;
import org.junit.jupiter.api.Test;
import service.ConnectionClass;
import service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    ConnectionClass cc = new ConnectionClassImpl();
    Connection connection = cc.connect();
    Statement statement = cc.statement(connection);
    StudentService ss = new StudentServiceImpl();

    StudentServiceImplTest() throws SQLException {
    }

    @Test
    void addToDataBase() throws SQLException{
        boolean result = ss.addToDataBase(statement, "'Nina Dine', 3, 2021");
        assertFalse(result);
    }

    @Test
    void deleteFromDataBase() throws SQLException {
        boolean result = ss.deleteFromDataBase(statement, "Full_name", "'Nina Dine'");

        assertFalse(result);
    }

    @Test
    void getAll() throws SQLException {

        List<Student> student = ss.getAll(statement);

        assertEquals(student.get(0).getId(),1011);
        assertEquals(student.get(0).getFullName(),"Ivan Tuz");
        assertEquals(student.get(0).getIdClass(),4);
        assertEquals(student.get(0).getYearAdmission(),2022);

        assertNotEquals(student.size(), 1019);

    }

    @Test
    void getByName() throws SQLException {
        List<Student> student = ss.getByName(statement, "'Kevin Ril'");

        assertEquals(student.toString(),
                "[Student: id - 1014, Kevin Ril, id - 2, year - 2022]");
        assertNotNull(student);


    }

    @Test
    void getByIds() throws SQLException {
        List<Student> student = ss.getByIds(statement, 1012);

        assertEquals(student.toString(),
                "[Student: id - 1012, Iryna Wolf, id - 5, year - 2020]");
        assertNotNull(student);

    }

    @Test
    void getByIdClass() throws SQLException {
        List<Student> student = ss.getByIdClass(statement, 1);

        assertEquals(student.size(), 2);
        assertNotNull(student);
    }
}