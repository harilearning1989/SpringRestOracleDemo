package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.dto.csv.CSVUser;

import java.util.List;

public interface CSVReadService {

    public List<EmployeeDTO> readEmployeeInfo();

    List<List<String>> readCsv();

    String readOpenCSV();

    String readUserCsv();

    List<CSVUser> readCSVToMode();

    List<CropInsuranceDTO> readCropInsuranceCSV();

    List<CropInsuranceDTO> readCropDetails();

    List<StudentDTO> readStudentInfo();

    List<Countries> readCountriesRegions();

    List<SalesOrderDTO> readSalesOrderDetails();

    List<IndiaStatesDTO> getIndiaStates();
}
