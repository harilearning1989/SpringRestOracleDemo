package com.example.demo.services;

import com.example.demo.entity.CropInsurance;

import java.util.List;

public interface IPlsqlService {
    public String procedureTest();
    public List<String> getArrayFunc();
    public List<CropInsurance> fetchCropInsuranceProcCursor();
}
