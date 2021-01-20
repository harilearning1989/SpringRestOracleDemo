package com.example.demo.services;

import com.example.demo.entity.CropInsurance;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

public interface ICropInsuranceService {
    Iterable<CropInsurance> getAllCropInsurance();
    List<CropInsurance> getByMandal(String mandal);
    List<CropInsurance> findByMandalNameIgnoreCase(String mandal);
    List<CropInsurance> findByMandalNameContainingIgnoreCase(String mandal);
    List<CropInsurance> findByMandalNameIgnoreCaseAndCropIgnoreCase(String mandal,String crop);
    List<CropInsurance> findByClaimAmountGreaterThanEqual(int start);
    List<CropInsurance> findByClaimAmountBetweenOrderByClaimAmount(int start,int end);
    List<CropInsurance> findByClaimAmountGreaterThanEqualLessThanEqual(int start,int end);
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(List<Integer> claimAmount);

}
