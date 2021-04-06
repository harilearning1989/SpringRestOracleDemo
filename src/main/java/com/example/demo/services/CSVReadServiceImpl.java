package com.example.demo.services;

import com.example.demo.async.*;
import com.example.demo.constants.IConstants;
import com.example.demo.dto.*;
import com.example.demo.dto.csv.CSVUser;
import com.example.demo.utils.CSVHelper;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.example.demo.utils.ExecutorServiceUtil.getTheExecutorService;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Service
public class CSVReadServiceImpl implements CSVReadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVReadServiceImpl.class);

    @Autowired
    private ResourceLoader resourceLoader;


    @Override
    public List<IndiaStatesDTO> getIndiaStates() {
        CompletableFuture<List<IndiaStatesDTO>> empFuture = supplyAsync(new ReadIndiaStatesSupplier(), getTheExecutorService());
        List<IndiaStatesDTO> empList = null;
        try {
            empList = empFuture.get();
            empList = Optional.ofNullable(empList)
                    .orElseGet(Collections::emptyList)
                    .parallelStream()
                    .filter(Objects::nonNull)
                    .filter(f -> !f.getStateName().contains("&"))
                    .filter(f -> f.getStateName() != null && f.getStateName().equalsIgnoreCase("HARYANA"))
                    .collect(Collectors.toList());
            return empList;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmployeeDTO> readEmployeeInfo() {
        CompletableFuture<List<EmployeeDTO>> empFuture = supplyAsync(new ReadEmployeeSupplier());
        List<EmployeeDTO> empList = null;
        try {
            TimeUnit.SECONDS.sleep(10);
            return empFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CropInsuranceDTO> readCropDetails() {
        CompletableFuture<List<CropInsuranceDTO>> cropFuture = supplyAsync(new ReadCropInsuranceSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StudentDTO> readStudentInfo() {
        CompletableFuture<List<StudentDTO>> cropFuture = supplyAsync(new ReadStudentSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Countries> readCountriesRegions() {
        CompletableFuture<List<Countries>> cropFuture = supplyAsync(new ReadCountriesSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SalesOrderDTO> readSalesOrderDetails() {
        CompletableFuture<List<SalesOrderDTO>> cropFuture = supplyAsync(new ReadSalesOrderSupplier());
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<List<String>> readCsv() {
        List<List<String>> records = null;
        try (BufferedReader br = new BufferedReader(new FileReader(IConstants.USERS_WITH_HEADER))) {
            String line;
            while ((line = br.readLine()) != null) {
                LOGGER.info(String.format("The Line===%1$s", line));
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public String readOpenCSV() {
        //CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();  //skip Header Row
        List<List<String>> records = null;
        try (CSVReader csvReader = new CSVReader(new FileReader(IConstants.USERS_WITH_HEADER));) {
            String[] line = null;
            while ((line = csvReader.readNext()) != null) {
                LOGGER.info(String.format("Line is===%1$s", line));
                records.add(Arrays.asList(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return "readOpenCSV";
    }

    @Override
    public String readUserCsv() {
        try (Reader reader = Files.newBufferedReader(Paths.get(IConstants.USERS_WITH_HEADER));
             CSVReader csvReader = new CSVReader(reader);) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                LOGGER.info(String.format("Line ===%1$s", line));
                LOGGER.info(String.format("Name : %1$s", line[0]));
                LOGGER.info(String.format("Email : %1$s", line[1]));
                LOGGER.info(String.format("Phone : %1$s", line[2]));
                LOGGER.info(String.format("Country : %1$s", line[3]));
                LOGGER.info("==========================");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return "readUserCsv";
    }

    @Override
    public List<CSVUser> readCSVToMode() {
        Iterator<CSVUser> csvUserIterator = null;
        List<CSVUser> usersList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(IConstants.USERS_WITH_HEADER));) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                LOGGER.info(String.format("Name : %1$s", csvUser.getName()));
                LOGGER.info(String.format("Email : %1$s", csvUser.getEmail()));
                LOGGER.info(String.format("PhoneNo : %1$s", csvUser.getPhoneNo()));
                LOGGER.info(String.format("Country : %1$s", csvUser.getCountry()));
                LOGGER.info("==========================");
                usersList.add(new CSVUser(csvUser.getName(), csvUser.getEmail(), csvUser.getPhoneNo(), csvUser.getCountry()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public List<CropInsuranceDTO> readCropInsuranceCSV() {
        Resource resource = resourceLoader.getResource("classpath:DataFiles/crop_insurance.csv");
        File file = null;
        try {
            file = resource.getFile();
            InputStream input = resource.getInputStream();
            List<CropInsuranceDTO> crops = CSVHelper.csvToCropInsurance(input);
            return crops;
        } catch (Exception e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

}
