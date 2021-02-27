package com.example.demo.batch.write;

import com.example.demo.entity.Student;
import com.example.demo.reposDev.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepository repo;

    @Override
    @Transactional
    public void write(List<? extends Student> users) throws Exception {
        repo.saveAll(users);
    }
}