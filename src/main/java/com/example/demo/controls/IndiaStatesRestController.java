package com.example.demo.controls;

import com.example.demo.entity.CropInsurance;
import com.example.demo.entity.IndiaStates;
import com.example.demo.services.IndiaStatesService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("india")
@Api(value = "IndiaStatesRestController")
public class IndiaStatesRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(IndiaStatesRestController.class);

    @Autowired
    private IndiaStatesService indiaStatesService;

    @GetMapping("/list")
    public ResponseEntity<List<IndiaStates>> getAllCropInsurance() {
        try {
            List<IndiaStates> indiaStates = indiaStatesService.getAllStates();
            if (indiaStates.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(indiaStates, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception at getAllCropInsurance :=" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/state")
    public List<IndiaStates> findByState(
            @RequestParam(defaultValue = "ANDHRA PRADESH") String state) {
        return indiaStatesService.findByStateNameIgnoreCase(state);
    }
}
