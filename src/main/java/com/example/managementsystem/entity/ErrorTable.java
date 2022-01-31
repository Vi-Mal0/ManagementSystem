package com.example.managementsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ErrorTable {
    @Id
    Long id;

    String Name;

}
