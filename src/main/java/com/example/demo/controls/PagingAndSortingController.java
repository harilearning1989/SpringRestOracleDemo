package com.example.demo.controls;

import com.example.demo.entity.City;
import com.example.demo.entity.Countries;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.ICityService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sorting")
@Api(value = "PagingAndSortingController")
public class PagingAndSortingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PagingAndSortingController.class);

    //programcreek.com/java-api-examples/?api=org.springframework.data.domain.Sort
    @Autowired
    private EmployeeService service;
    @Autowired
    private ICityService cityService;

    @GetMapping("defaultSort")
    public ResponseEntity<List<Countries>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy) {
        List<Countries> list = service.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("desendSort")
    public ResponseEntity<List<Countries>> getAllEmployeesDescending(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name") String sortBy) {
        List<Countries> list = service.getAllEmployeesDescending(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("pagingOnly")
    public ResponseEntity<List<Countries>> getEmpPagingOnly(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Countries> list = service.getEmpPagingOnly(pageNo, pageSize);

        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("sortOnly")
    public ResponseEntity<List<Countries>> getEmpSortingOnly(
            @RequestParam(defaultValue = "name") String first,
            @RequestParam(defaultValue = "region") String second) {
        List<Countries> list = service.getEmpSortingOnly(first, second);

        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("sortOrder")
    public ResponseEntity<List<Countries>> getEmpSortOrder() {
        List<Countries> list = service.getEmpSortOrder();
        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("nullsLast")
    public ResponseEntity<List<Countries>> getEmpSortNullsLast() {
        List<Countries> list = service.getEmpSortNullsLast();
        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("nullsFirst")
    public ResponseEntity<List<Countries>> getEmpSortNullsFirst() {
        List<Countries> list = service.getEmpSortNullsFirst();
        return new ResponseEntity<List<Countries>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/cities")
    public List<City> getCitiesByPopulation() {
        return cityService.findAllOrderByPopulationAsc();
    }

    @GetMapping(value = "/cities2")
    public List<City> getCitiesByName(@RequestParam(defaultValue = "name") String name) {
        return cityService.findAllOrderByNameAsc(name);
    }
}
