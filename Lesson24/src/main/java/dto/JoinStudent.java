package dto;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class JoinStudent extends Student{

    @Setter
    @Getter
    @Accessors(chain = true)
    private int idClass;
    private String className;

    public JoinStudent(int id, String fullName, int yearAdmission, int idClass, String className) {
        super(id, fullName, yearAdmission);
        this.idClass = idClass;
        this.className = className;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "id - " + idClass +
                ", " + className;
    }
}
