package com.example.demo.controls;

import com.example.demo.dto.CropInsuranceDTO;
import com.example.demo.dto.csv.CSVUser;
import com.example.demo.dto.csv.Tutorial;
import com.example.demo.response.ResponseMessage;
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

import java.util.List;

@RestController
@RequestMapping("csv")
@Api(value = "CSVReadRestController")
public class CSVReadRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVReadRestController.class);

    @Autowired
    private CSVReadService csvReadService;

    @Value("${csv.read.readCsv}")
    private String load;

    @ApiOperation(value = "uploadCSV")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @PostMapping(value = "uploadCSV")
    public List<Tutorial> uploadCSV(@RequestParam("file") MultipartFile file) {
        List<Tutorial> tutorials = csvReadService.uploadCSV(file);
        return tutorials;
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

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> readTutorialsCSV() {
        try {
            List<Tutorial> tutorials = csvReadService.readTutorialsCSV();
            return ResponseEntity.status(HttpStatus.OK).body(tutorials);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
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
