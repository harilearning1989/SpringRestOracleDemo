package com.example.demo.services;

import com.example.demo.entity.CountriesEntity;

public interface ICountriesService {

    public Iterable<CountriesEntity> getAllCountries();
}
