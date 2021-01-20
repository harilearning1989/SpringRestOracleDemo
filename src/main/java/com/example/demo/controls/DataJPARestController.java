package com.example.demo.controls;

import com.example.demo.entity.CropInsurance;
import com.example.demo.services.ICropInsuranceService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("dataJpa")
@Api(value = "DataJPARestController")
public class DataJPARestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataJPARestController.class);

    @Autowired
    private ICropInsuranceService iCropInsuranceService;

    @GetMapping("/list")
    public ResponseEntity<List<CropInsurance>> getAllCropInsurance() {
        try {
            List<CropInsurance> CropInsurance = new ArrayList<CropInsurance>();
            iCropInsuranceService.getAllCropInsurance().forEach(CropInsurance::add);
            if (CropInsurance.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(CropInsurance, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception at getAllCropInsurance :=" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/list/mandal")
    public List<CropInsurance> getByMandal(@RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iCropInsuranceService.getByMandal(mandal);
    }
    @GetMapping("/list/case")
    public List<CropInsurance> findByMandalNameIgnoreCase(@RequestParam(defaultValue = "BUKKAPATNAM") String mandal) {
        return iCropInsuranceService.findByMandalNameIgnoreCase(mandal);
    }
    @GetMapping("/list/contain")
    public List<CropInsurance> findByMandalNameContainingIgnoreCase(@RequestParam(defaultValue = "NALLAMADA") String mandal) {
        return iCropInsuranceService.findByMandalNameContainingIgnoreCase(mandal);
    }

    @GetMapping("/list/and")
    public List<CropInsurance> findByMandalNameIgnoreCaseAndCropIgnoreCase(
            @RequestParam(defaultValue = "Nallamada") String mandal,
            @RequestParam(defaultValue = "Groundnut (Pea Nut) - RF") String crop) {
        return iCropInsuranceService.findByMandalNameIgnoreCaseAndCropIgnoreCase(mandal,crop);
    }
    @GetMapping("/list/greater")
    public List<CropInsurance> findByClaimAmountGreaterThanEqual(
            @RequestParam(defaultValue = "1000") int start) {
        return iCropInsuranceService.findByClaimAmountGreaterThanEqual(start);
    }

    @GetMapping("/list/between")
    public List<CropInsurance> findByClaimAmountBetweenOrderByClaimAmount(
            @RequestParam(defaultValue = "9900") int start,
            @RequestParam(defaultValue = "10000") int end) {
        return iCropInsuranceService.findByClaimAmountBetweenOrderByClaimAmount(start,end);
    }

    @GetMapping("/list/greaterAndLess")
    public List<CropInsurance> findByClaimAmountGreaterThanEqualLessThanEqual(
            @RequestParam(defaultValue = "1000") int start,
            @RequestParam(defaultValue = "10000") int end) {
        return iCropInsuranceService.findByClaimAmountGreaterThanEqualLessThanEqual(start,end);
    }
    @GetMapping("/list/{amountIn}")
    public List<CropInsurance> findByClaimAmountIn(
            @PathVariable List<Integer> amountIn) {
        for(Integer amount : amountIn) {
            System.out.println("amountIn:=" + amount);
        }
        return iCropInsuranceService.findByClaimAmountInOrderByClaimAmount(amountIn);
    }

    @GetMapping(value = "/between/{mandal}/{crop}")
    public List<CropInsurance> findByRollNumberBetween(
            @PathVariable String mandal,
            @PathVariable String crop) {
        return iCropInsuranceService.findByMandalNameIgnoreCaseAndCropIgnoreCase(mandal,crop);
    }

}
