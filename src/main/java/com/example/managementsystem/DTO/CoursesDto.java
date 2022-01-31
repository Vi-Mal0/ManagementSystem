package com.example.managementsystem.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CoursesDto {

    private Long courseId;

    private String courseName;

    private int courseFee;

    private int months;

    Set<String> enrolledStudents = new HashSet<>();

}
