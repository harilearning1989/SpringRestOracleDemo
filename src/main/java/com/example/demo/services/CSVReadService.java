package com.example.demo.services;

import com.example.demo.dto.CropInsuranceDTO;
import com.example.demo.dto.csv.CSVUser;
import com.example.demo.dto.csv.Tutorial;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface CSVReadService {
    List<Tutorial> uploadCSV(MultipartFile file);

    List<List<String>> readCsv();

    String readOpenCSV();

    String readUserCsv();

    List<CSVUser> readCSVToMode();

    List<Tutorial> save(MultipartFile file);

    InputStream load();

    List<Tutorial> readTutorialsCSV();

    List<CropInsuranceDTO> readCropInsuranceCSV();
}
