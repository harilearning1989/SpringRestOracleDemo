package com.example.demo.controls;

import com.example.demo.entity.CropInsurance;
import com.example.demo.services.ICriteriaService;
import com.example.demo.services.IPlsqlService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("criteria")
@Api(value = "CriteriaRestController")
public class CriteriaRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CriteriaRestController.class);

    @Autowired
    private ICriteriaService iCriteriaService;

    @GetMapping("/mandal")
    public List<CropInsurance> getByMandal(@RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iCriteriaService.getByMandal(mandal);
    }
    @GetMapping("/mandalAndCrop")
    public List<CropInsurance> getByMandalAndCrop(
            @RequestParam(defaultValue = "Mudigubba") String mandal,
            @RequestParam(defaultValue = "Groundnut") String crop) {
        return iCriteriaService.getByMandalAndCrop(mandal,crop);
    }
    @GetMapping("/mandalOrCrop")
    public List<CropInsurance> getByMandalOrCrop(
            @RequestParam(defaultValue = "Mudigubba") String mandal,
            @RequestParam(defaultValue = "Groundnut") String crop) {
        return iCriteriaService.getByMandalOrCrop(mandal,crop);
    }

}
