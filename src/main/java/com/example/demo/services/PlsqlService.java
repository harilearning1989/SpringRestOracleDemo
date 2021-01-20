package com.example.demo.services;

import com.example.demo.entity.CropInsurance;
import com.example.demo.repos.IPlsqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlsqlService implements IPlsqlService {

    @Autowired
    private IPlsqlRepository iPlsqlRepository;

    @Override
    public String procedureTest() {
        iPlsqlRepository.inOnlyTest("Reddy");
        return iPlsqlRepository.inAndOutTest("Hari==");
    }
    @Override
    public List<String> getArrayFunc() {
        return iPlsqlRepository.getArrayFunc();
    }
    @Override
    public List<CropInsurance> fetchCropInsuranceProcCursor() {
        List<CropInsurance> cropList = iPlsqlRepository.findCropsViaProcedure();
        return cropList;
    }
}
