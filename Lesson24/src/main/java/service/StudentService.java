package service;

import dto.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public interface StudentService {
    boolean addToDataBase(Statement statement, String values) throws SQLException;

    boolean deleteFromDataBase(Statement statement, String column, String values) throws SQLException;

    List<Student> getAll(Statement statement) throws SQLException;

    List<Student> getByName(Statement statement, String name) throws SQLException;

    List<Student> getByIds(Statement statement, int ids)throws SQLException;

    List<Student> getByIdClass(Statement statement, int idc) throws SQLException;
}
