package com.example.managementsystem.entity;


import ENUM.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class BankDetails {

    @Id
    Long id;

    String bankName;

    @Enumerated(EnumType.STRING)
    AccountType accoutType;

    String accontNumber;

    String ifscCode;

    String branch;

}
