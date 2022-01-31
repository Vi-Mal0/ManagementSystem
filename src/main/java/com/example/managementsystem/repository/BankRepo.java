package com.example.managementsystem.repository;

import com.example.managementsystem.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankDetails , Long> {
}
