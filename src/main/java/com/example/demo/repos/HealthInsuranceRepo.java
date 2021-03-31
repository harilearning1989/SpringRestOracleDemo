package com.example.demo.repos;

import com.example.demo.entity.EmployeeHealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthInsuranceRepo extends JpaRepository<EmployeeHealthInsurance, Long> {
}
