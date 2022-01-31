package com.example.managementsystem.repository;

import com.example.managementsystem.entity.Student_profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsProfileRepository extends JpaRepository<Student_profile, Long>
{

}
