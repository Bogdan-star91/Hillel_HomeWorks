package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Bohdan Hrytsai
 */

@Setter
@Getter
@Accessors(chain = true)
public class Student {
    private int id;
    private String fullName;
    private int idClass;
    private int yearAdmission;

    public Student() {
    }

    public Student(int id, String fullName,  int yearAdmission) {
        this.id = id;
        this.fullName = fullName;
        this.yearAdmission = yearAdmission;
    }

    public Student(int id, String fullName, int idClass, int yearAdmission) {
        this.id = id;
        this.fullName = fullName;
        this.idClass = idClass;
        this.yearAdmission = yearAdmission;
    }

    @Override
    public String toString() {
        return "Student: " +
                "id - " + id +
                ", " + fullName +
                ", id - " + idClass +
                ", year - " + yearAdmission;
    }
}
