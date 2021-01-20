package com.example.demo.services;

import com.example.demo.entity.Countries;
import com.example.demo.entity.CropInsurance;
import com.example.demo.repos.ICountriesRepository;
import com.example.demo.repos.IQueryMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryMethodsService implements IQueryMethodsService {

    @Autowired
    private IQueryMethodsRepository iQueryMethodsRepository;

    @Autowired
    private ICountriesRepository iCountriesRepository;

    @Override
    public Iterable<CropInsurance> getAllCropInsurance() {
        return iQueryMethodsRepository.findAll();
    }

    @Override
    public List<CropInsurance> getByMandal(String mandal) {
        return iQueryMethodsRepository.findByMandalName(mandal);
    }
    @Override
    public List<CropInsurance> getByMandalIgnoreCase(String mandal) {
        return iQueryMethodsRepository.findByMandalNameIgnoreCase(mandal);
    }

    @Override
    public List<CropInsurance> findDistinctByMandalName(String mandal) {
        return iQueryMethodsRepository.findDistinctByMandalName(mandal);
    }

    @Override
    public List<String> findMandalNameDistinct() {
        return iQueryMethodsRepository.findMandalNameDistinct();
    }

    @Override
    public List<String> findMandalName() {
        return iQueryMethodsRepository.findMandalName();
    }
    @Override
    public String countTheVillages() {
        return iQueryMethodsRepository.countTheVillages();
    }
    @Override
    public String countTheVillagesByMandal(String mandal) {
        return iQueryMethodsRepository.countTheVillagesByMandal(mandal);
    }
    @Override
    public List<CropInsurance> findDistinctByMandalNameAndCrop(String mandal,String crop) {
        return iQueryMethodsRepository.findDistinctByMandalNameAndCrop(mandal,crop);
    }
    @Override
    public List<CropInsurance> findByMandalNameAndCrop(String mandal,String crop) {
        return iQueryMethodsRepository.findByMandalNameAndCrop(mandal,crop);
    }
    @Override
    public List<CropInsurance> findByMandalNameOrCrop(String mandal,String crop) {
        return iQueryMethodsRepository.findByMandalNameOrCrop(mandal,crop);
    }
    @Override
    public List<CropInsurance> findByClaimAmountLessThanEqual(int claimAmount) {
        return iQueryMethodsRepository.findByClaimAmountLessThanEqual(claimAmount);
    }
    @Override
    public List<CropInsurance> findByClaimAmountGreaterThanEqual(int claimAmount) {
        return iQueryMethodsRepository.findByClaimAmountGreaterThanEqual(claimAmount);
    }
    @Override
    public List<Countries> findByIntRegionNull() {
        return iCountriesRepository.findByIntRegionNull();
    }
    @Override
    public List<Countries> findByIntRegionNotNull() {
        return iCountriesRepository.findByIntRegionNotNull();
    }
    @Override
    public List<CropInsurance> findByVillNameLike(String villName) {
        return iQueryMethodsRepository.findByVillNameLike(villName);
    }
    @Override
    public List<CropInsurance> findByVillNameNotLike(String villName) {
        return iQueryMethodsRepository.findByVillNameNotLike(villName);
    }
    @Override
    public List<CropInsurance> findByVillNameStartingWith(String villName) {
        return iQueryMethodsRepository.findByVillNameStartingWith(villName);
    }
    @Override
    public List<CropInsurance> findByVillNameEndingWith(String villName) {
        return iQueryMethodsRepository.findByVillNameEndingWith(villName);
    }
    @Override
    public List<CropInsurance> findByVillNameContaining(String villName) {
        return iQueryMethodsRepository.findByVillNameContaining(villName);
    }
    @Override
    public List<CropInsurance> findByMandalNameOrderByVillNameDesc(String mandal) {
        return iQueryMethodsRepository.findByMandalNameOrderByVillNameDesc(mandal);
    }
    @Override
    public List<CropInsurance> findByMandalNameNot(String mandal) {
        return iQueryMethodsRepository.findByMandalNameNot(mandal);
    }

    @Override
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(List<Integer> claimAmount) {
        return iQueryMethodsRepository.findByClaimAmountInOrderByClaimAmount(claimAmount);
    }
    @Override
    public List<CropInsurance> findByClaimAmountNotInOrderByClaimAmount(List<Integer> claimAmount) {
        return iQueryMethodsRepository.findByClaimAmountNotInOrderByClaimAmount(claimAmount);
    }

    /*repo.findByAndSort("lannister", Sort.by("firstname"));
repo.findByAndSort("stark", Sort.by("LENGTH(firstname)"));
repo.findByAndSort("targaryen", JpaSort.unsafe("LENGTH(firstname)"));
repo.findByAsArrayAndSort("bolton", Sort.by("fn_len"));*/
}
