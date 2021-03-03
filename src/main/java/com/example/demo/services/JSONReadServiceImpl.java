package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.utils.IDemoUtils;
import com.example.demo.utils.IStaticData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class JSONReadServiceImpl implements JSONReadService {

    private static final String JSON_FILE_LOCATION = "json/";

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONReadServiceImpl.class);

    @Override
    public List<CountryCurrency> postCountryCurrency(MultipartFile file) {
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public AllCountriesRegion getAllRegions() {
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

    @Override
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

    @Override
    public Set<String> getCountries(String region) {
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
    @Override
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
    @Override
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
    @Override
    public List<CountryStates> getCountryStates() {
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
    @Override
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
    @Override
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
    @Override
    public List<MovieDTO> readMovies() {
        LOGGER.info("readMovies==========");
        List<MovieDTO> movieDTOList = null;
        try {
            String fixture = IDemoUtils.readResource(JSON_FILE_LOCATION + "movie.json", Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            movieDTOList = objectMapper.readValue(fixture, objectMapper.getTypeFactory().constructCollectionType(List.class, MovieDTO.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movieDTOList;
    }
}
