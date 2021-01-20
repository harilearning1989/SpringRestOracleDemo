package com.example.demo.services;

import com.example.demo.entity.Countries;
import com.example.demo.entity.CropInsurance;

import java.util.List;

public interface IQueryMethodsService {

    Iterable<CropInsurance> getAllCropInsurance();
    List<CropInsurance> getByMandal(String mandal);
    List<CropInsurance> getByMandalIgnoreCase(String mandal);
    List<CropInsurance> findDistinctByMandalName(String mandal);
    List<String> findMandalNameDistinct();
    List<String> findMandalName();
    String countTheVillages();
    String countTheVillagesByMandal(String mandal);
    List<CropInsurance> findDistinctByMandalNameAndCrop(String mandal,String crop);
    List<CropInsurance> findByMandalNameAndCrop(String mandal,String crop);
    List<CropInsurance> findByMandalNameOrCrop(String mandal,String crop);
    List<CropInsurance> findByClaimAmountLessThanEqual(int claimAmount);
    List<CropInsurance> findByClaimAmountGreaterThanEqual(int claimAmount);
    List<Countries> findByIntRegionNull();
    List<Countries> findByIntRegionNotNull();
    List<CropInsurance> findByVillNameLike(String villName);
    List<CropInsurance> findByVillNameNotLike(String villName);
    List<CropInsurance> findByVillNameStartingWith(String villName);
    List<CropInsurance> findByVillNameEndingWith(String villName);
    List<CropInsurance> findByVillNameContaining(String villName);
    List<CropInsurance> findByMandalNameOrderByVillNameDesc(String mandal);
    List<CropInsurance> findByMandalNameNot(String mandal);
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(List<Integer> claimAmount);
    public List<CropInsurance> findByClaimAmountNotInOrderByClaimAmount(List<Integer> claimAmount);


}
