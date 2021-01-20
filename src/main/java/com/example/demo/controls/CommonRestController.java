package com.example.demo.controls;

import com.example.demo.entity.Countries;
import com.example.demo.services.ICountriesService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("common")
@Api(value = "CommonRestController")
public class CommonRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonRestController.class);

    @Autowired
    private ICountriesService iCountriesService;

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    public @ResponseBody String getAllUsers(ModelMap model) {
        String jsonData = "[{\"id\":\"3253123\",\"firstname\":\"Chris\",\"lastname\":\"Johnson\",\"address\":\"211, Geoffrey Drive\",\"city\":\"Newark\",\"phone\":\"999-888-6666\",\"email\":\"chrisj@yahoo.com\"},{\"id\":\"67643837\",\"firstname\":\"Bill\",\"lastname\":\"Derkson\",\"address\":\"201, Sleepy Hollow Drive\",\"city\":\"Newark\",\"phone\":\"999-777-2222\",\"email\":\"billd@gmail.com\"}]";
        return jsonData;
    }

    @RequestMapping(value = "/getAllProfiles", method = RequestMethod.GET)
    public @ResponseBody String getAllProfiles(ModelMap model) {
        String jsonData = "[{\"firstname\":\"ajitesh\",\"lastname\":\"kumar\",\"address\":\"211/20-B,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-888-6666\"},{\"firstname\":\"nidhi\",\"lastname\":\"rai\",\"address\":\"201,mgstreet\",\"city\":\"hyderabad\",\"phone\":\"999-876-5432\"}]";
        return jsonData;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Countries>> getAllCountries() {
        try {
            List<Countries> countries = new ArrayList<Countries>();
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
