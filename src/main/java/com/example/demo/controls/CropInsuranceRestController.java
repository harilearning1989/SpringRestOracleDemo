package com.example.demo.controls;

import com.example.demo.entity.CropInsurance;
import com.example.demo.services.ICropInsuranceService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("crop")
@Api(value = "CropInsuranceRestController")
public class CropInsuranceRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CropInsuranceRestController.class);

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

}
