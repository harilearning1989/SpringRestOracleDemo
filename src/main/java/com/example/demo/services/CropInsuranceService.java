package com.example.demo.services;

import com.example.demo.entity.CropInsurance;
import com.example.demo.repos.ICropInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropInsuranceService implements ICropInsuranceService {

    @Autowired
    private ICropInsuranceRepository iCropInsuranceRepository;

    @Override
    public Iterable<CropInsurance> getAllCropInsurance() {
        return iCropInsuranceRepository.findAll();
    }

    @Override
    public List<CropInsurance> getByMandal(String mandal) {
        return iCropInsuranceRepository.findByMandalName(mandal);
    }

    @Override
    public List<CropInsurance> findByMandalNameIgnoreCase(String mandal) {
        return iCropInsuranceRepository.findByMandalNameIgnoreCase(mandal);
    }

    @Override
    public List<CropInsurance> findByMandalNameContainingIgnoreCase(String mandal) {
        return iCropInsuranceRepository.findByMandalNameContainingIgnoreCase(mandal);
    }

    @Override
    public List<CropInsurance> findByMandalNameIgnoreCaseAndCropIgnoreCase(String mandal, String crop) {
        return iCropInsuranceRepository.findByMandalNameIgnoreCaseAndCropIgnoreCase(mandal, crop);
    }

    @Override
    public List<CropInsurance> findByClaimAmountGreaterThanEqual(int start) {
        return iCropInsuranceRepository.findByClaimAmountGreaterThanEqual(start);
    }

    @Override
    public List<CropInsurance> findByClaimAmountBetweenOrderByClaimAmount(int start, int end) {
        return iCropInsuranceRepository.findByClaimAmountBetweenOrderByClaimAmount(start, end);
    }

    @Override
    public List<CropInsurance> findByClaimAmountGreaterThanEqualLessThanEqual(int start, int end) {
        return iCropInsuranceRepository.findByClaimAmountGreaterThanEqualAndClaimAmountLessThanEqualOrderByClaimAmount(start, end);
    }

    @Override
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(List<Integer> claimAmount) {
        return iCropInsuranceRepository.findByClaimAmountInOrderByClaimAmount(claimAmount);
    }
}
