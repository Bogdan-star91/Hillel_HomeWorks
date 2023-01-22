package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ConnectionClass {
    Connection connect() throws SQLException;

    Statement statement (Connection conn) throws SQLException;

    String closeConnect(Connection conn) throws  SQLException;
}
