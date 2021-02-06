package com.example.demo.feign;

import com.example.demo.dto.Countries;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "CountriesData", url = "http://localhost:8082/countries/")
public interface CountriesFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "list")
    List<Countries> getAllCountries();
}
