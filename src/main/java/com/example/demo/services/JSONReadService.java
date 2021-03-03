package com.example.demo.services;

import com.example.demo.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface JSONReadService {
    List<CountryCurrency> postCountryCurrency(MultipartFile file);

    User readUserJson();

    List<CountryCurrency> getCountryCurrency();

    List<CountriesCode> getCountriesCodes();

    List<Countries> getCountries();

    AllCountriesRegion getAllRegions();

    List<CountryState> getTheCountry();

    public Set<String> getCountries(String region);

    public Set<String> getTheRegions();

    List<AllCountries> allCountriesData();

    List<CountryStates> getCountryStates();

    CovidData getCovidData();

    CompleteAddress getAddress();

    List<MovieDTO> readMovies();
}
