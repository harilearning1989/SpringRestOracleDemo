package com.example.demo.repos;

import com.example.demo.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<StudentInfo, Long> {
    public List<StudentInfo> findByCategoryAndGender(String category, String gender);

    public List<StudentInfo> findByFatherName(String fatherName);

    @Query(name = "Get Student Info", value = "select * from student_info s where s.FATHER_NAME = ?1", nativeQuery = true)
    Collection<StudentInfo> getStudentTable(String fatherName);
}
