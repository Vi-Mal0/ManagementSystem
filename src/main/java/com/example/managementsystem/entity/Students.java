package com.example.managementsystem.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Students
{
	@Id
	private Long studentId;
	
	private String studentName;

	private Long departmentId;

	@ManyToMany(mappedBy = "enrolledStudents")
	private List<Courses> courses = new ArrayList<>();
}
