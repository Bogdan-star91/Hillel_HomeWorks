package app;

public class Student {
    private static int Next_Id = 0;
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String birthYear;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student() {
        id = Next_Id++;
    }

    public Student(String surname, String name, String middleName, String birthYear, String address, String phone,
                   String faculty, int course, String group) {
        id = Next_Id++;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student: " + id + " "
                + surname +
                " " + name +
                " " + middleName + ',' +
                " " + birthYear + ',' +
                " " + address + ',' +
                " " + phone + ',' +
                " " + faculty + ',' +
                " " + course + ',' +
                " " + group;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
