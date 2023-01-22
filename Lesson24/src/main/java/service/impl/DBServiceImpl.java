package service.impl;

import dto.JoinStudent;
import lombok.extern.slf4j.Slf4j;
import service.DBService;
import service.Joins;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bohdan Hrytsai
 * @version 2.1.0
 *
 * @since version 2.0.1
 */
@Slf4j
public class DBServiceImpl implements DBService {

    /**
     *
     * @param statement static SQL statement
     * @param data script to create tables
     * @throws SQLException
     */
    @Override
    public String createTable(Statement statement, String data) throws SQLException {
        statement.execute(data);
        return "Table created !!!";
    }

    /**
     *
     * @param statement static SQL statement
     * @param name table name
     * @throws SQLException
     */
    @Override
    public String deleteTable(Statement statement, String name) throws SQLException {
        statement.execute("drop table " + name);
        return "Table deleted !!!";
    }


    /**
     *
     * @param statement static SQL statement
     * @param name table name
     * @throws SQLException
     */
    @Override
    public void infoTable(Statement statement, String name) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from " + name);

        System.out.println("Table name : " + rs.getMetaData().getTableName(2)); //true
        System.out.println("*********************");
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("column name : " + rs.getMetaData().getColumnName(i) + ", ");
            System.out.print("column size : " + rs.getMetaData().getColumnDisplaySize(i) + ", ");
            System.out.println("column type : " + rs.getMetaData().getColumnTypeName(i));
        }
        System.out.println();
    }

    /**
     *
     * @param statement static SQL statement
     * @param joins {@link Joins}
     * @return union table students and class {@link JoinStudent}
     * @throws SQLException that provides information on a database
     */
    @Override
    public List<JoinStudent> getJoin(Statement statement, Joins joins) throws SQLException {
        ResultSet rs = statement.executeQuery
                ("select  ID_student, Full_name, Year_admission, ID_class, Name_class " +
                        "from students " +
                        joins + " join class " +
                        "on students.Class = class.ID_class");
        List<JoinStudent> studentJ = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String fullName = rs.getString("Full_name");
            int yearAdmission = rs.getInt("Year_admission");
            int idClass = rs.getInt("ID_class");
            String className = rs.getString("Name_class");
            studentJ.add(new JoinStudent(id, fullName, yearAdmission, idClass, className));
        }
        return studentJ;
    }
}
