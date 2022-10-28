package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentService {
    public static void getFaculty(Student[] arr, String faculty) {
        for (Student s : arr) {
            if (s.getFaculty().equals(faculty)) {
                System.out.println(s);
            }
        }
    }

    public static void getFacultyAndCourse(Student[] arr, String faculty, int course) {
        for (Student s : arr) {
            if (s.getFaculty().equals(faculty) && s.getCourse() == course) {
                System.out.println(s);
            }
        }
    }

    public static void getOlderStudent(Student[] arr, String data) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        for (Student s : arr) {
            if (new SimpleDateFormat("dd/MM/yyyy").parse(s.getBirthYear()).getTime() > date.getTime()) {
                System.out.println(s);
            }
        }
    }

    public static void getGroup(Student[] arr, String group) {
        for (Student s : arr) {
            if (s.getGroup().equals(group)) {
                System.out.println(s);
            }

        }
    }
}
