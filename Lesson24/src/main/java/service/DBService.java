package service;

import dto.JoinStudent;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DBService {

    String createTable(Statement statement,String data) throws SQLException;

    String deleteTable(Statement statement,String name) throws SQLException;

    void infoTable(Statement statement, String name) throws SQLException;

    List<JoinStudent> getJoin (Statement statement, Joins joins) throws SQLException;
}
