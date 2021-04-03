package com.example.demo.controls;

import com.example.demo.entity.CropInsurance;
import com.example.demo.entity.StudentInfo;
import com.example.demo.services.RelationService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/relations")
@Api(value = "RelationsRestController")
public class RelationsRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryMethodsRestController.class);

    @Autowired
    private RelationService relationService;

    @GetMapping("/list")
    public ResponseEntity<List<StudentInfo>> getStudentInfo() {
        try {
            List<StudentInfo> studentInfo = relationService.getStudentInfo();
            if (studentInfo.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studentInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception at getAllCropInsurance :=" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categoryAndGender")
    public List<StudentInfo> findByCategoryAndGender(
            @RequestParam(defaultValue = "OC") String category,
            @RequestParam(defaultValue = "Male") String gender) {
        return relationService.findByCategoryAndGender(category, gender);
    }
    @GetMapping("/fatherName")
    public List<StudentInfo> findByFatherName(
            @RequestParam(defaultValue = "A Gopal") String fatherName) {
        return relationService.findByFatherName(fatherName);
    }
    @GetMapping("/student")
    public Collection<StudentInfo> getStudentTable(
            @RequestParam(defaultValue = "A Gopal") String fatherName) {
        return relationService.getStudentTable(fatherName);
    }
}
