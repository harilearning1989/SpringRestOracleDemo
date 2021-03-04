package com.example.demo.controls;

import com.example.demo.dto.*;
import com.example.demo.services.JSONReadService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("json")
public class JSONReadRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONReadRestController.class);

    @Autowired
    public JSONReadService jsonReadService;

    @ApiOperation(value = "Hello World")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/helloWorld")
    public String helloWorld() {
        LOGGER.info("Hello World Logger");
        return "Hello World";
    }

    @ApiOperation(value = "postCountryCurrency")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @PostMapping(value = "/countryCurrency")
    public List<CountryCurrency> postCountryCurrency(@RequestParam("file") MultipartFile file) {
        LOGGER.info("postCountryCurrency==========");
        List<CountryCurrency> countryRegion = jsonReadService.postCountryCurrency(file);

        return countryRegion;
    }

    @ApiOperation(value = "readUserJson")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/user")
    public User readUserJson() {
        LOGGER.info("readUserJson==========");
        User user = jsonReadService.readUserJson();
        return user;
    }

    @ApiOperation(value = "getCountryCurrency")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/countryCurrency")
    public List<CountryCurrency> getCountryCurrency() {
        LOGGER.info("getCountryCurrency==========");
        List<CountryCurrency> countryRegion = jsonReadService.getCountryCurrency();
        return countryRegion;
    }

    @ApiOperation(value = "getCountriesCodes")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/countryCode")
    public List<CountriesCode> getCountriesCodes() {
        LOGGER.info("getCountriesCodes==========");
        List<CountriesCode> countryRegion = jsonReadService.getCountriesCodes();
        return countryRegion;
    }

    @ApiOperation(value = "getCountries")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/countries")
    public List<Countries> getCountries() {
        LOGGER.info("getCountries==========");
        List<Countries> countryRegion = jsonReadService.getCountries();
        return countryRegion;
    }

    @ApiOperation(value = "GetAllRegions")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/all")
    public AllCountriesRegion getAllRegions() {
        LOGGER.info("GetAllRegions==========");
        AllCountriesRegion countryRegion = jsonReadService.getAllRegions();
        return countryRegion;
    }

    @ApiOperation(value = "getTheCountry")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/countryState")
    public List<CountryState> getTheCountry() {
        LOGGER.info("getTheCountry==========");
        List<CountryState> countryRegion = jsonReadService.getTheCountry();
        return countryRegion;
    }

    @ApiOperation(value = "getCountries")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/allRegionCountiesByRegion")
    public Set<String> getCountries(@RequestParam(value = "region") String region) {
        LOGGER.info("getCountries==========");
        Set<String> countries = jsonReadService.getCountries(region);
        return countries;
    }

    @ApiOperation(value = "getTheRegions")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/allRegionCountiesRegion")
    public Set<String> getTheRegions() {
        LOGGER.info("getTheRegions==========");
        Set<String> regions = jsonReadService.getTheRegions();
        return regions;
    }

    @ApiOperation(value = "allCountriesData")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/allRegionCounties")
    public List<AllCountries> allCountriesData() {
        LOGGER.info("allCountriesData==========");
        List<AllCountries> countryRegion = jsonReadService.allCountriesData();
        return countryRegion;
    }

    @ApiOperation(value = "countryStates")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/countryStates")
    public List<CountryStates> getCountryStates() {
        LOGGER.info("countryStates==========");
        List<CountryStates> countryRegion = jsonReadService.getCountryStates();
        return countryRegion;
    }

    @ApiOperation(value = "getCovidData")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/covidData")
    public CovidData getCovidData() {
        LOGGER.info("getCovidData==========");
        CovidData covidData = jsonReadService.getCovidData();
        return covidData;
    }

    @ApiOperation(value = "getAddress")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/address")
    public CompleteAddress getAddress() {
        LOGGER.info("getAddress==========");
        CompleteAddress address = jsonReadService.getAddress();
        return address;
    }

    @ApiOperation(value = "readMovies")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/movies")
    public List<MovieDTO> readMovies() {
        LOGGER.info("readMovies==========");
        List<MovieDTO> movieDTOList = jsonReadService.readMovies();
        return movieDTOList;
    }
}
