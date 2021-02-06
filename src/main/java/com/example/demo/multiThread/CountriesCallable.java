package com.example.demo.multiThread;

import com.example.demo.dto.Countries;
import com.example.demo.feign.CountriesFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;

@Component
public class CountriesCallable implements Callable<List<Countries>> {

    @Autowired
    private CountriesFeignClient countriesFeignClient;

    @Override
    public List<Countries> call() throws Exception {
        return countriesFeignClient.getAllCountries();
    }
}
