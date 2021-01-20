package com.example.demo.services;

import com.example.demo.dao.ICriteriaDAO;
import com.example.demo.entity.CropInsurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CriteriaService implements ICriteriaService{

    @Autowired
    private ICriteriaDAO iCriteriaDAO;

    @Override
    public List<CropInsurance> getByMandal(String mandal) {
        return iCriteriaDAO.getByMandal(mandal);
    }

    @Override
    public List<CropInsurance> getByMandalAndCrop(String mandal, String crop) {
        return iCriteriaDAO.getByMandalAndCrop(mandal,crop);
    }
    @Override
    public List<CropInsurance> getByMandalOrCrop(String mandal, String crop) {
        return iCriteriaDAO.getByMandalOrCrop(mandal,crop);
    }
}
