package com.example.managementsystem.entity;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Departments implements Serializable
{
	@Id
	private Long deptId;
	private String deptName;

	
	@OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Students> students = new ArrayList<>();

}
