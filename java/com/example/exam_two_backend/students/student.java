package com.example.exam_two_backend.students;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = student.TABLE_NAME)
public class student {

    public static final String TABLE_NAME = "STUDENT";

    public student(Long id, String name, String dept, String grade) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long user_id) {
        this.id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(generator = TABLE_NAME + "_GENERATOR")
    @SequenceGenerator(
            name = TABLE_NAME + "_GENERATOR",
            sequenceName = TABLE_NAME + "_SEQUENCE"
    )
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    String name;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Column(name = "DEPT")
    String dept;

    @Column(name = "GRADE")
    String grade;
}

