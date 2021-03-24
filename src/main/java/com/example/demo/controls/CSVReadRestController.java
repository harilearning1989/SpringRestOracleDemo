package com.example.demo.controls;

import com.example.demo.dto.*;
import com.example.demo.dto.csv.CSVUser;
import com.example.demo.response.ResponseMessage;
import com.example.demo.services.AsyncService;
import com.example.demo.services.CSVReadService;
import com.example.demo.utils.CSVHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping("csv")
@Api(value = "CSVReadRestController")
public class CSVReadRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVReadRestController.class);

    @Autowired
    private CSVReadService csvReadService;
    @Autowired
    private AsyncService asyncService;

    @Value("${csv.read.readCsv}")
    private String load;

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

    @ApiOperation(value = "readCsv")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "load")
    public List<List<String>> readCsv() {
        List<List<String>> records = csvReadService.readCsv();
        return records;
    }

    @ApiOperation(value = "readOpenCSV")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "openCSV")
    public String readOpenCSV() {
        //CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();  //skip Header Row
        String records = csvReadService.readOpenCSV();
        return "readOpenCSV";
    }

    @ApiOperation(value = "readUserCsv")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "userCsv")
    public String readUserCsv() {
        String str = csvReadService.readUserCsv();
        return "readUserCsv";
    }

    @ApiOperation(value = "readCSVToMode")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(value = "readCSVToMode")
    public List<CSVUser> readCSVToMode() {
        List<CSVUser> usersList = csvReadService.readCSVToMode();
        return usersList;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                csvReadService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/crops")
    public ResponseEntity<List<CropInsuranceDTO>> readCropInsuranceCSV() {
        try {
            List<CropInsuranceDTO> cropInsurance = csvReadService.readCropInsuranceCSV();
            return ResponseEntity.status(HttpStatus.OK).body(cropInsurance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "tutorials.csv";
        InputStreamResource file = new InputStreamResource(csvReadService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

}
