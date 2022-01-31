package com.example.managementsystem.repository;

import com.example.managementsystem.entity.ErrorTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepo extends JpaRepository<ErrorTable, Long> {
}
