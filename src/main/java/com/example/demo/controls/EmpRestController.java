package com.example.demo.controls;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repos.IEmployeeRepository;
import com.example.demo.track.TrackExecutionTime;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("emp")
@Api(value = "EmpRestController")
public class EmpRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpRestController.class);
    @Autowired
    private IEmployeeRepository employeeRepository;

    @ApiOperation(value = "Read Employee by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping("/list")
    @TrackExecutionTime
    public List<Employee> getAllEmployees() {
        LOGGER.info("getAllEmployees===");
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "Read Employee by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping("/read/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        LOGGER.info("getEmployeeById===");
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @ApiOperation(value = "Create Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        LOGGER.info("createEmployee===");
        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Update Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        LOGGER.info("updateEmployee===");
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @ApiOperation(value = "Delete Employee by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        LOGGER.info("deleteEmployee===");
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}