package com.example.demo.controls;

import com.example.demo.dto.RandomNumber;
import com.example.demo.entity.CropInsurance;
import com.example.demo.entity.Person;
import com.example.demo.repos.IMyTableRepository;
import com.example.demo.repos.IPersonRepository;
import com.example.demo.services.IPlsqlService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("plsql")
@Api(value = "PlsqlRestController")
public class PlsqlRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlsqlRestController.class);

    @Autowired
    private IMyTableRepository myTableRepository;

    @Autowired
    private IPlsqlService iPlsqlService;

    @Autowired
    private IPersonRepository iPersonRepository;

    @GetMapping(value = "/inOnlyTest")
    public String getCountryCurrency() {
        myTableRepository.inOnlyTest("Reddy");
        return myTableRepository.inAndOutTest("Hari==");
    }

    @GetMapping(value = "/procTest")
    public String procedureTest() {
        return iPlsqlService.procedureTest();
    }

    @GetMapping(value = "/procCursor")
    public List<CropInsurance> fetchCropInsuranceProcCursor() {
        return iPlsqlService.fetchCropInsuranceProcCursor();
    }

    @GetMapping(value = "/arrFunc")
    public List<String> getArrayFunc() {
        return iPlsqlService.getArrayFunc();
    }

    @GetMapping(value = "/person")
    public List<Person> fetchPersonHistory() {
        return iPersonRepository.fetchPersonHistory();
    }

    @GetMapping(value = "/randomNumNative")
    public List<RandomNumber> getNumberUptoNativeSql() {
        List<Object[]> listObj = iPersonRepository.getNumberUptoNativeSql();
        List<RandomNumber> listRowNum = new ArrayList<>();
        listObj.forEach(l -> {
            RandomNumber rowNum = new RandomNumber();
            Object[] objArr = l;
            BigDecimal bigDecimal = (BigDecimal) objArr[0];
            int id = Integer.valueOf(bigDecimal.intValue());
            String rowId = String.valueOf(objArr[1]);
            rowNum.setId(id);
            rowNum.setRowId(rowId);
            listRowNum.add(rowNum);
        });
        return listRowNum;
    }

}
