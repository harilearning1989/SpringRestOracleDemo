package com.example.demo.dao;

import com.example.demo.entity.CropInsurance;

import java.util.List;

public interface ICriteriaDAO {

    List<CropInsurance> getByMandal(String mandal);
    List<CropInsurance> getByMandalAndCrop(String mandal, String crop);
    List<CropInsurance> getByMandalOrCrop(String mandal, String crop);
}
