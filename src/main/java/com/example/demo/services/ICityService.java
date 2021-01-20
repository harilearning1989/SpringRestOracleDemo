package com.example.demo.services;

import com.example.demo.entity.City;

import java.util.List;

public interface ICityService {
    List<City> findAllOrderByPopulationAsc();
    List<City> findAllOrderByNameAsc(String name);
}
