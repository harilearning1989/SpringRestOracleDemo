package com.example.demo.async;

import com.example.demo.dto.Countries;
import com.example.demo.dto.CountriesDTO;
import com.example.demo.read.download.DownloadGitHubFiles;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Supplier;

public class ReadCountriesSupplier implements Supplier<List<Countries>> {
    @Override
    public List<Countries> get() {
        try {
            DownloadGitHubFiles.downloadFile("csv/CountriesRegions.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Countries> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/CountriesRegions.csv"))
                    .withType(Countries.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
