package app;

import java.text.ParseException;

public class StudentRun extends StudentService {

    public static void main(String[] args) throws ParseException {
        Student st = new Student();
        st.setAddress("centralnay 12a");
        st.setBirthYear("14/05/2001");
        st.setCourse(3);
        st.setFaculty("Psychology");
        st.setGroup("P3");
        st.setPhone("+380965241215");
        st.setName("Yroslav");
        st.setSurname("Zyk");
        st.setMiddleName("Vladimirovich");
        Student[] arr = {
                st,
                new Student("Gristay", "Bogdan", "Dmitrievich",
                        "27/02/1991", "tolbukhina 135b", "+380977257358", "IT", 2,
                        "I2"),
                new Student("Demchenko", "Irina", "Vaycheslavivna",
                        "05/07/2000", "maykovskoho 76", "+380966251475", "IT", 3,
                        "I3"),
                new Student("Zuz", "Denys", "Ihorovich",
                        "06/01/1998", "lozova 77", "+380632214875", "Psychology", 4,
                        "P4"),
                new Student("Sydorenko", "Inna", "Serheevna",
                        "15/07/1990", "zykova 31", "+380503215685", "Journalism", 1,
                        "J1"),
                new Student("Solomko", "Evgeniy", "Oleksandrovich",
                        "26/05/1993", "bendery 90", "+380682203156", "IT", 1,
                        "I1"),
                new Student("Zul", "Mika", "Olegovna",
                        "11/09/1990", "Kapa 7", "+380965430011", "Psychology", 1,
                        "P1"),
                new Student("Laz", "Irina", "Sergeevna",
                        "28/04/1992", "dona 76", "+380989076512", "IT", 2, "I2"),
                new Student("Syz", "Nik", "Fedorovich",
                        "19/10/1997", "dyka 23", "+380674531908", "Journalism", 3,
                        "J3"),
                new Student("Hek", "Inna", "Denisovna",
                        "13/01/1998", "viva 9", "+30634780976", "Psychology", 4,
                        "P4"),
        };

        System.out.println("\nList of students of a given faculty IT: ");
        getFaculty(arr, "IT");

        System.out.println("\nList of students for faculty and course 4: ");
        getFacultyAndCourse(arr, "Psychology", 4);

        System.out.println("\nList of students born after 30/09/1996: ");
        getOlderStudent(arr, "30/09/1996");

        System.out.println("\nStudy group list Journalism: ");
        getGroup(arr, "J3");
    }
}
