package com.example.demo.async;

import com.example.demo.dto.StudentDTO;
import com.example.demo.read.download.DownloadGitHubFiles;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadStudentSupplier implements Supplier<List<StudentDTO>> {
    @Override
    public List<StudentDTO> get() {
        try {
            DownloadGitHubFiles.downloadFile("csv/StudentInfo.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<StudentDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/StudentInfo.csv"))
                    .withType(StudentDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
