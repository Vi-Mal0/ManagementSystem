package com.example.managementsystem.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
public class Courses implements Serializable
{
    @Id
    private Long courseId;

    private String courseName;
    private int courseFee;
    private int months;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "Enrolled_Students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    public List<Students> enrolledStudents = new ArrayList<>();

    public void enrollStudent(Students students){
        enrolledStudents.add(students);
    }
    public void deleteStudent(Students students){
        enrolledStudents.remove(students);
    }
}
