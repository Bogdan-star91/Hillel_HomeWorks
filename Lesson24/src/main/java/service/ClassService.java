package service;

import dto.Class;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface ClassService {
    boolean addToDataBase(Statement statement, String values) throws SQLException;

    boolean deleteFromDataBase(Statement statement, String column, String values) throws SQLException;

    List<Class> getAll(Statement statement) throws SQLException;

    List<Class> getByName(Statement statement, String name) throws SQLException;

    List<Class> getByIds(Statement statement, int ids)throws SQLException;
}
