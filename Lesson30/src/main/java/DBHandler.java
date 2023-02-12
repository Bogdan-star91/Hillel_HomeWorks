import java.sql.SQLException;
import java.util.List;

public interface DBHandler {

    boolean addStudent(Student student);

    List<Student> getAll();

    List<Student> getByName(String name);

    List<Student> getByIds(List<Integer> ids) throws SQLException;

}
