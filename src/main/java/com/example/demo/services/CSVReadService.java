package com.example.demo.services;

import com.example.demo.dto.CropInsuranceDTO;
import com.example.demo.dto.csv.CSVUser;

import java.util.List;

public interface CSVReadService {

    List<List<String>> readCsv();

    String readOpenCSV();

    String readUserCsv();

    List<CSVUser> readCSVToMode();

    List<CropInsuranceDTO> readCropInsuranceCSV();
}
