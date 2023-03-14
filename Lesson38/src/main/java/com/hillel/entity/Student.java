package com.hillel.entity;

import javax.persistence.*;

/**
 * @author Bohdan Hrytsai
 */

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "Id" )
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Last_Name")
    private String lustName;

    @Column(name = "Id_Class")
    private int idClass;

    @Column(name = "Year_Admission")
    private int yearAdmission;

    public Student() {
    }

    public Student(int id, String name, String lastName, int yearAdmission) {
        this.id = id;
        this.name = name;
        this.lustName = lastName;
        this.yearAdmission = yearAdmission;
    }

    public Student(String name, String lastName,  int idClass, int yearAdmission) {
        this.name = name;
        this.idClass = idClass;
        this.lustName = lastName;
        this.yearAdmission = yearAdmission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLustName() {
        return lustName;
    }

    public void setLustName(String lustName) {
        this.lustName = lustName;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getYearAdmission() {
        return yearAdmission;
    }

    public void setYearAdmission(int yearAdmission) {
        this.yearAdmission = yearAdmission;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lustName='" + lustName + '\'' +
                ", idClass=" + idClass +
                ", yearAdmission=" + yearAdmission +
                '}';
    }
}
