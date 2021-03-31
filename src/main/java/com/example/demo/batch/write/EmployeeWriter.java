package com.example.demo.batch.write;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repos.EmployeeRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EmployeeWriter implements ItemWriter<EmployeeEntity> {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    @Transactional
    public void write(List<? extends EmployeeEntity> users) throws Exception {
        employeeRepo.saveAll(users);
    }
}
