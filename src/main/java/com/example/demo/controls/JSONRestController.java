package com.example.demo.controls;

import com.example.demo.dto.*;
import com.example.demo.utils.IDemoUtils;
import com.example.demo.utils.IStaticData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("json")
public class JSONRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONRestController.class);

    private static final String JSON_FILE_LOCATION = "json/";

    @ApiOperation(value = "Hello World")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/helloWorld")
    public String helloWorld() {
        LOGGER.info("Hello World Logger");
        return "Hello World";
    }

    @ApiOperation(value = "postCountryCurrency")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @PostMapping(value = "/countryCurrency")
    public List<CountryCurrency> postCountryCurrency(@RequestParam("file") MultipartFile file) {
        LOGGER.info("postCountryCurrency==========");
        List<CountryCurrency> countryRegion = null;
        String content = IDemoUtils.getBytesFromMultipartFile(file);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            countryRegion = objectMapper.readValue(content,
                    objectMapper.getTypeFactory()
                            .constructCollectionType(List.class, CountryCurrency.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "readUserJson")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/user")
    public User readUserJson() {
        LOGGER.info("readUserJson==========");
        User user = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "users.json", StandardCharsets.UTF_8);
            //String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "users.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(fixture, User.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @ApiOperation(value = "getCountryCurrency")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/countryCurrency")
    public List<CountryCurrency> getCountryCurrency() {
        LOGGER.info("getCountryCurrency==========");
        List<CountryCurrency> countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "CountryCurrency.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, CountryCurrency.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "getCountriesCodes")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/countryCode")
    public List<CountriesCode> getCountriesCodes() {
        LOGGER.info("getCountriesCodes==========");
        List<CountriesCode> countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "CountryCode.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, CountriesCode.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "getCountries")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/countries")
    public List<Countries> getCountries() {
        LOGGER.info("getCountries==========");
        List<Countries> countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "Countries.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, Countries.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "GetAllRegions")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/all")
    public AllCountriesRegion GetAllRegions() {
        LOGGER.info("GetAllRegions==========");
        AllCountriesRegion countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "all.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, AllCountriesRegion.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "getTheCountry")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/countryState")
    public List<CountryState> getTheCountry() {
        LOGGER.info("getTheCountry==========");
        List<CountryState> countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "CountryState.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, CountryState.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "getCountries")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/allRegionCountiesByRegion")
    public Set<String> getCountries(@RequestParam(value = "region") String region) {
        LOGGER.info("getCountries==========");
        List<AllCountries> countryRegion = null;
        Set<String> countries = new TreeSet<>();
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "allRegionCounties.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, AllCountries.class));
            for (AllCountries all : countryRegion) {
                if (!all.getRegion().isEmpty() && region.equalsIgnoreCase(all.getRegion())) {
                    countries.add(all.getName());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countries;
    }

    @ApiOperation(value = "getTheRegions")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/allRegionCountiesRegion")
    public Set<String> getTheRegions() {
        LOGGER.info("getTheRegions==========");
        List<AllCountries> countryRegion = null;
        Set<String> regions = new TreeSet<>();
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "allRegionCounties.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, AllCountries.class));
            for (AllCountries all : countryRegion) {
                regions.add(all.getRegion());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return regions;
    }

    @ApiOperation(value = "allCountriesData")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/allRegionCounties")
    public List<AllCountries> allCountriesData() {
        LOGGER.info("allCountriesData==========");
        List<AllCountries> countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "allRegionCounties.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, AllCountries.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "countryStates")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/countryStates")
    public List<CountryStates> countryStates() {
        LOGGER.info("countryStates==========");
        List<CountryStates> countryRegion = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "CountryStates.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, CountryStates.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    @ApiOperation(value = "getCovidData")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/covidData")
    public CovidData getCovidData() {
        LOGGER.info("getCovidData==========");
        CovidData covidData = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "CovidData.json", Charsets.UTF_8);

            ObjectMapper objectMapper = new ObjectMapper();
            covidData = objectMapper.readValue(fixture, CovidData.class);
            //ClassLoader classLoader = getClass().getClassLoader();
            //File file = new File(classLoader.getResource("CovidData.json").getFile());
            //byte[] mapData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return covidData;
    }

    @ApiOperation(value = "getAddress")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 Message"),
            @ApiResponse(code = 200,message = "200 Success Message")
    })
    @GetMapping(value = "/address")
    public CompleteAddress getAddress() {
        LOGGER.info("getAddress==========");
        ObjectMapper objectMapper = new ObjectMapper();
        CompleteAddress address = null;
        try {
            address = objectMapper.readValue(IStaticData.JSONDATA, CompleteAddress.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }
}
