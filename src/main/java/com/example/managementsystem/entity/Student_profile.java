package com.example.managementsystem.entity;


import ENUM.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Student_profile
{

	@Id
	private long id;
	 
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String addressLine1;
    private String addressLine2;

    private String city;
    private String state;
    private String pincode;
    private String country;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "student_Id", referencedColumnName = "studentId", nullable = false)
    private Students students;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private BankDetails bankDetails;

}
