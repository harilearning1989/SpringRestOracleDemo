package com.example.demo.services;

import com.example.demo.entity.Countries;

import java.util.List;

public interface ICountriesService {

    public Iterable<Countries> getAllCountries();
}
