package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class Class {
    private int id;
    private String className;

    public Class() {
    }

    public Class(int id, String className) {
        this.id = id;
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id - " + id +
                ", class - '" + className;
    }
}
