package com.example.demo.batch.write;

import com.example.demo.entity.CropInsurance;
import com.example.demo.repos.ICropInsuranceRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CropInsuranceWriter implements ItemWriter<CropInsurance> {

    @Autowired
    private ICropInsuranceRepository repo;

    @Override
    @Transactional
    public void write(List<? extends CropInsurance> users) throws Exception {
        repo.saveAll(users);
    }
}
