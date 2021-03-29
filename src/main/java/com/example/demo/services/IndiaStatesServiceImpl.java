package com.example.demo.services;

import com.example.demo.entity.IndiaStates;
import com.example.demo.repos.IndiaStatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndiaStatesServiceImpl implements IndiaStatesService {

    @Autowired
    private IndiaStatesRepo indiaStatesRepo;

    @Override
    public List<IndiaStates> getAllStates() {
        return indiaStatesRepo.findAll();
    }

    @Override
    public List<IndiaStates> findByStateNameIgnoreCase(String state) {
        return indiaStatesRepo.findByStateNameIgnoreCase(state);
    }
}
