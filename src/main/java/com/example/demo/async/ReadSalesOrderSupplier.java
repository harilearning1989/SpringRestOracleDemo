package com.example.demo.async;

import com.example.demo.dto.SalesOrderDTO;
import com.example.demo.read.download.DownloadGitHubFiles;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ReadSalesOrderSupplier implements Supplier<List<SalesOrderDTO>> {
    @Override
    public List<SalesOrderDTO> get() {
        try {
            DownloadGitHubFiles.downloadFile("csv/SalesOrder.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SalesOrderDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader("D:/DataFiles/Downloaded/csv/SalesOrder.csv"))
                    .withType(SalesOrderDTO.class)
                    .build()
                    .parse();
            listCrop = Optional.ofNullable(listCrop)
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .filter(f -> f.getOrderPriority().equalsIgnoreCase("h"))
                    .collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
