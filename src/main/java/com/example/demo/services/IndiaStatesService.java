package com.example.demo.services;

import com.example.demo.entity.IndiaStates;

import java.util.List;

public interface IndiaStatesService {
    List<IndiaStates> getAllStates();

    List<IndiaStates> findByStateNameIgnoreCase(String state);
}
