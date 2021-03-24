package com.example.demo.controls;

import com.example.demo.dto.*;
import com.example.demo.services.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping("/async")
@Api(value = "AsyncRestController")
public class AsyncRestController {

    private static Logger log = LoggerFactory.getLogger(AsyncRestController.class);

    @Autowired
    private AsyncService asyncService;

    @GetMapping(value = "/readSyncData")
    public void readCSVSync() {
        long startTime = System.currentTimeMillis();
        List<CropInsuranceDTO> cropDetails = asyncService.readCropDetails("csv/crop_insurance.csv");
        List<StudentDTO> studentInfo = asyncService.readStudentInfo("csv/StudentInfo.csv");
        List<EmployeeDTO> employeeInfo = asyncService.readEmployeeInfo("csv/employee.csv");
        List<Countries> countriesRegions = asyncService.readCountriesRegions("csv/CountriesRegions.csv");
        List<SalesOrderDTO> salesOrderDetails = asyncService.readSalesOrderDetails("csv/100000_Sales_Order.csv");
        System.out.println("CropSize==" + cropDetails.size() + "==StudentSize==" + studentInfo.size() + "==EmpSize==" + employeeInfo.size() +
                "==CountrySize==" + countriesRegions.size() + "===SalesSize===" + salesOrderDetails.size());
        long endTime = System.currentTimeMillis();
        System.out.println("Sync Total Time Taken==" + (endTime - startTime));
    }

    @GetMapping(value = "/readAsyncData")
    public void readCSVAsync() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<List<CropInsuranceDTO>> cropFuture = supplyAsync(() -> asyncService.readCropDetails("csv/crop_insurance.csv"));
        CompletableFuture<List<StudentDTO>> studentFuture = supplyAsync(() -> asyncService.readStudentInfo("csv/StudentInfo.csv"));
        //CompletableFuture<List<EmployeeDTO>> empFuture = supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"));
        CompletableFuture<List<Countries>> countriesFuture = supplyAsync(() -> asyncService.readCountriesRegions("csv/CountriesRegions.csv"));
        CompletableFuture<List<SalesOrderDTO>> salesFuture = supplyAsync(() -> asyncService.readSalesOrderDetails("csv/100000_Sales_Order.csv"));
        /*CompletableFuture<List<EmployeeDTO>> empFutureTime =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"))
                        .orTimeout(2, TimeUnit.SECONDS);*/
        CompletableFuture<List<EmployeeDTO>> empFuture =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"))
                        .completeOnTimeout(new ArrayList<>(), 1, TimeUnit.SECONDS);
        CompletableFuture.allOf(cropFuture, studentFuture, empFuture, countriesFuture, salesFuture);
        try {
            List<CropInsuranceDTO> cropList = cropFuture.get();
            List<StudentDTO> stdList = studentFuture.get();
            List<EmployeeDTO> empList = empFuture.get();
            List<Countries> contList = countriesFuture.get();
            List<SalesOrderDTO> saleList = salesFuture.get();
            System.out.println("CropSize==" + cropList.size() + "==StudentSize==" + stdList.size() + "==EmpSize==" + empList.size() +
                    "==CountrySize==" + contList.size() + "===SalesSize===" + saleList.size());
            long endTime = System.currentTimeMillis();
            System.out.println("===========================================");
            System.out.println("ASync Total Time Taken==" + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "Read All CSV Files")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/readAll")
    public void readAllCSVFiles() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<List<CropInsuranceDTO>> cropFuture = supplyAsync(() -> asyncService.readCropDetails("csv/crop_insurance.csv"));
        CompletableFuture<List<StudentDTO>> studentFuture = supplyAsync(() -> asyncService.readStudentInfo("csv/StudentInfo.csv"));
        //CompletableFuture<List<EmployeeDTO>> empFuture = supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"));
        CompletableFuture<List<Countries>> countriesFuture = supplyAsync(() -> asyncService.readCountriesRegions("csv/CountriesRegions.csv"));
        CompletableFuture<List<SalesOrderDTO>> salesFuture = supplyAsync(() -> asyncService.readSalesOrderDetails("csv/100000_Sales_Order.csv"));
        /*CompletableFuture<List<EmployeeDTO>> empFutureTime =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"))
                        .orTimeout(2, TimeUnit.SECONDS);*/
        CompletableFuture<List<EmployeeDTO>> empFuture =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"))
                        .completeOnTimeout(new ArrayList<>(), 1, TimeUnit.SECONDS);
        CompletableFuture.allOf(cropFuture, studentFuture, empFuture, countriesFuture, salesFuture);
        try {
            List<CropInsuranceDTO> cropList = cropFuture.get();
            List<StudentDTO> stdList = studentFuture.get();
            List<EmployeeDTO> empList = empFuture.get();
            List<Countries> contList = countriesFuture.get();
            List<SalesOrderDTO> saleList = salesFuture.get();
            System.out.println("CropSize==" + cropList.size() + "==StudentSize==" + stdList.size() + "==EmpSize==" + empList.size() +
                    "==CountrySize==" + contList.size() + "===SalesSize===" + saleList.size());
            long endTime = System.currentTimeMillis();
            System.out.println("===========================================");
            System.out.println("ASync Total Time Taken==" + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "Read All CSV Files")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "/readCrop")
    public List<CropInsuranceDTO> readCropCSV() {
        CompletableFuture<List<CropInsuranceDTO>> cropFuture =
                supplyAsync(() -> asyncService.readCropDetails("csv/crop_insurance.csv"));
        try {
            return cropFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/readStudent")
    public List<StudentDTO> readStudentCSV() {
        CompletableFuture<List<StudentDTO>> studentFuture =
                supplyAsync(() -> asyncService.readStudentInfo("csv/StudentInfo.csv"));
        try {
            return studentFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/readEmp")
    public List<EmployeeDTO> readEmpCSV() {
        CompletableFuture<List<EmployeeDTO>> empFuture =
                supplyAsync(() -> asyncService.readEmployeeInfo("csv/employee.csv"));
        try {
            return empFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/readCountry")
    public List<Countries> readCountryCSV() {
        CompletableFuture<List<Countries>> countriesFuture =
                supplyAsync(() -> asyncService.readCountriesRegions("csv/CountriesRegions.csv"));
        try {
            return countriesFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping(value = "/readSales")
    public List<SalesOrderDTO> readSalesCSV() {
        CompletableFuture<List<SalesOrderDTO>> salesFuture =
                supplyAsync(() -> asyncService.readSalesOrderDetails("csv/100000_Sales_Order.csv"));
        try {
            return salesFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
