package com.example.demo.async;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.read.download.DownloadGitHubFiles;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ReadEmployeeSupplier implements Supplier<List<EmployeeDTO>> {
    @Override
    public List<EmployeeDTO> get() {
        try {
            DownloadGitHubFiles.downloadFile("csv/employee.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EmployeeDTO> listCrop = null;
        try {
            TimeUnit.SECONDS.sleep(2);
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/employee.csv"))
                    .withType(EmployeeDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
