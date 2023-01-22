package service.impl;


import com.mysql.cj.jdbc.MysqlDataSource;
import service.ConnectionClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClassImpl implements ConnectionClass {


    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost";
    public static final String databaseName ="student";
    public static final int portNumber = 3306;
    public static final String user = "root";
    public static final String password = "Bd271991";

    @Override
    public Connection connect() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName( serverName );
        dataSource.setDatabaseName( databaseName );
        dataSource.setPortNumber( portNumber );
        dataSource.setUser( user );
        dataSource.setPassword( password );

        return dataSource.getConnection();
    }

    @Override
    public Statement statement (Connection conn) throws SQLException {
        return conn.createStatement();
    }

    @Override
    public String closeConnect(Connection conn) throws  SQLException {
        conn.close();
        return null;
    }
}
