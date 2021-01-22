package com.example.demo.reposDev;

import java.util.List;

import com.example.demo.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	List<Assignment> findByStudentId(Long studentId);	
}
