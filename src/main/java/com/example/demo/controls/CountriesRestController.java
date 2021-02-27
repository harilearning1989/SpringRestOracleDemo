package com.example.demo.controls;

import com.example.demo.entity.CountriesEntity;
import com.example.demo.services.ICountriesService;
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
@RequestMapping("countries")
public class CountriesRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountriesRestController.class);

    @Autowired
    private ICountriesService iCountriesService;

    @GetMapping("/helloWorld")
    private String helloWorld() {
        return "CountriesRestController Hello World";
    }

    @GetMapping("/list")
    public ResponseEntity<List<CountriesEntity>> getAllCountries() {
        try {
            List<CountriesEntity> countries = new ArrayList<CountriesEntity>();
            iCountriesService.getAllCountries().forEach(countries::add);
            if (countries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception at getAllCountries :="+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
