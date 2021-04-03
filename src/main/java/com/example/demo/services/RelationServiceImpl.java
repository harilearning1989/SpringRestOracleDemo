package com.example.demo.services;

import com.example.demo.entity.StudentInfo;
import com.example.demo.repos.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationRepository relationRepository;

    @Override
    public List<StudentInfo> getStudentInfo() {
        return relationRepository.findAll();
    }

    @Override
    public List<StudentInfo> findByCategoryAndGender(String category, String gender) {
        return relationRepository.findByCategoryAndGender(category, gender);
    }

    @Override
    public List<StudentInfo> findByFatherName(String fatherName) {
        return relationRepository.findByFatherName(fatherName);
    }

    @Override
    public Collection<StudentInfo> getStudentTable(String fatherName) {
        return relationRepository.getStudentTable(fatherName);
    }
}
