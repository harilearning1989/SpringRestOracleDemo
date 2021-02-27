package com.example.demo.batch.write;

import com.example.demo.entity.Employee;
import com.example.demo.repos.IEmployeeRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

    @Autowired
    private IEmployeeRepository repo;

    @Override
    @Transactional
    public void write(List<? extends Employee> users) throws Exception {
        repo.saveAll(users);
    }
}
