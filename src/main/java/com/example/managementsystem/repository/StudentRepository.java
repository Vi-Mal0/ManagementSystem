package com.example.managementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managementsystem.entity.Students;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long>
{
    Optional<Students> getByStudentId(Long studentId);
    
    Students findByStudentId(Long studentId);

}
