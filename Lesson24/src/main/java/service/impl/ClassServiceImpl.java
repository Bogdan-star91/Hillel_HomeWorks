package service.impl;

import dto.Class;
import service.ClassService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService {
    @Override
    public boolean addToDataBase(Statement statement, String values) throws SQLException {
        return statement.execute("insert into class " +
                "(Name_class) " +
                "values (" + values + ")");
    }

    @Override
    public boolean deleteFromDataBase(Statement statement, String column, String values) throws SQLException {
        return statement.execute("delete from class where " +
                column + "=" + values);
    }

    @Override
    public List<Class> getAll(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from students");
        List<Class> classList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String className = rs.getString("Name_class");
            classList.add(new Class(id, className));
        }
        return classList;
    }

    @Override
    public List<Class> getByName(Statement statement, String name) throws SQLException {
        ResultSet rs = statement.executeQuery
                ("select * from students where Full_name = " + name);
        List<Class> classList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String className = rs.getString("Name_class");
            classList.add(new Class(id, className));
        }
        return classList;
    }

    @Override
    public List<Class> getByIds(Statement statement, int idc) throws SQLException {
        ResultSet rs = statement.executeQuery
                ("select * from students where Full_name = " + idc);
        List<Class> classList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String className = rs.getString("Name_class");
            classList.add(new Class(id, className));
        }
        return classList;
    }

}
