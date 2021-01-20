package com.example.demo.controls;

import com.example.demo.entity.Countries;
import com.example.demo.entity.CropInsurance;
import com.example.demo.services.IQueryMethodsService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/query")
@Api(value = "QueryMethodsRestController")
public class QueryMethodsRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryMethodsRestController.class);

    @Autowired
    private IQueryMethodsService iQueryMethodsService;

    //findByActiveTrue
    //findByActiveFalse
    //findByFirstnameIgnoreCase
    //Orderby IgnoreCase nulls last
    //findByStartDateBetween
    //findByStartDateAfter
    //findByStartDateBefore
    //JPA Named Queries

    @GetMapping("/list")
    public ResponseEntity<List<CropInsurance>> getAllCropInsurance() {
        try {
            List<CropInsurance> CropInsurance = new ArrayList<CropInsurance>();
            iQueryMethodsService.getAllCropInsurance().forEach(CropInsurance::add);
            if (CropInsurance.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(CropInsurance, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception at getAllCropInsurance :=" + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mandal")
    public List<CropInsurance> getByMandal(@RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iQueryMethodsService.getByMandal(mandal);
    }
    @GetMapping("/mandal/case")
    public List<CropInsurance> getByMandalIgnoreCase(@RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iQueryMethodsService.getByMandalIgnoreCase(mandal);
    }

    @GetMapping("/dist")
    public List<CropInsurance> findDistinctByMandalName(
            @RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iQueryMethodsService.findDistinctByMandalName(mandal);
    }

    @GetMapping("/dist/mandal")
    public List<String> findMandalNameDistinct() {
        return iQueryMethodsService.findMandalNameDistinct();
    }

    @GetMapping("/dist/native")
    public List<String> findMandalName() {
        return iQueryMethodsService.findMandalName();
    }
    @GetMapping("/count")
    public String countTheVillages() {
        return iQueryMethodsService.countTheVillages();
    }
    @GetMapping("/count/mandal")
    public String countTheVillagesByMandal(
            @RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iQueryMethodsService.countTheVillagesByMandal(mandal);
    }

    @GetMapping("/mandalAndCrop")
    public List<CropInsurance> findByMandalNameAndCrop(
            @RequestParam(defaultValue = "Mudigubba") String mandal,
            @RequestParam(defaultValue = "Groundnut") String crop) {
        return iQueryMethodsService.findByMandalNameAndCrop(mandal,crop);
    }

    @GetMapping("/mandalOrCrop")
    public List<CropInsurance> findByMandalNameOrCrop(
            @RequestParam(defaultValue = "Mudigubba") String mandal,
            @RequestParam(defaultValue = "Groundnut") String crop) {
        return iQueryMethodsService.findByMandalNameOrCrop(mandal,crop);
    }

    @GetMapping("/DistMandalAndCrop")
    public List<CropInsurance> findDistinctByMandalNameAndCrop(
            @RequestParam(defaultValue = "Mudigubba") String mandal,
            @RequestParam(defaultValue = "Groundnut") String crop) {
        return iQueryMethodsService.findDistinctByMandalNameAndCrop(mandal,crop);
    }

    @GetMapping("/claimAmountLessThanEqual")
    public List<CropInsurance> findByClaimAmountLessThanEqual(
            @RequestParam(defaultValue = "1000") int claimAmount) {
        return iQueryMethodsService.findByClaimAmountLessThanEqual(claimAmount);
    }

    @GetMapping("/claimAmountGreaterThanEqual")
    public List<CropInsurance> findByClaimAmountGreaterThanEqual(
            @RequestParam(defaultValue = "1000") int claimAmount) {
        return iQueryMethodsService.findByClaimAmountGreaterThanEqual(claimAmount);
    }

    @GetMapping("/intRegionNull")
    public List<Countries> findByIntRegionNull() {
        return iQueryMethodsService.findByIntRegionNull();
    }
    @GetMapping("/intRegionNotNull")
    public List<Countries> findByIntRegionNotNull() {
        return iQueryMethodsService.findByIntRegionNotNull();
    }

    @GetMapping("/villNameLike")
    public List<CropInsurance> findByVillNameLike(
            @RequestParam(defaultValue = "Dorigallu") String villName) {
        return iQueryMethodsService.findByVillNameLike(villName);
    }

    @GetMapping("/villNameNotLike")
    public List<CropInsurance> findByVillNameNotLike(
            @RequestParam(defaultValue = "Dorigallu") String villName) {
        return iQueryMethodsService.findByVillNameNotLike(villName);
    }

    @GetMapping("/villNameStartingWith")
    public List<CropInsurance> findByVillNameStartingWith(
            @RequestParam(defaultValue = "Dor") String villName) {
        return iQueryMethodsService.findByVillNameStartingWith(villName);
    }

    @GetMapping("/villNameEndingWith")
    public List<CropInsurance> findByVillNameEndingWith(
            @RequestParam(defaultValue = "allu") String villName) {
        return iQueryMethodsService.findByVillNameEndingWith(villName);
    }

    @GetMapping("/villNameContaining")
    public List<CropInsurance> findByVillNameContaining(
            @RequestParam(defaultValue = "allu") String villName) {
        return iQueryMethodsService.findByVillNameContaining(villName);
    }

    @GetMapping("/mandalNameOrderByVillNameDesc")
    public List<CropInsurance> findByMandalNameOrderByVillNameDesc(
            @RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iQueryMethodsService.findByMandalNameOrderByVillNameDesc(mandal);
    }
    @GetMapping("/mandalNameNot")
    public List<CropInsurance> findByMandalNameNot(
            @RequestParam(defaultValue = "Mudigubba") String mandal) {
        return iQueryMethodsService.findByMandalNameNot(mandal);
    }

    @GetMapping("/claimAmountIn/{amountIn}")
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(
            @PathVariable List<Integer> amountIn) {
        for(Integer amount : amountIn) {
            System.out.println("amountIn:=" + amount);
        }
        return iQueryMethodsService.findByClaimAmountInOrderByClaimAmount(amountIn);
    }

    @GetMapping("/claimAmountNotIn/{amountIn}")
    public List<CropInsurance> findByClaimAmountNotInOrderByClaimAmount(
            @PathVariable List<Integer> amountIn) {
        for(Integer amount : amountIn) {
            System.out.println("amountIn:=" + amount);
        }
        return iQueryMethodsService.findByClaimAmountNotInOrderByClaimAmount(amountIn);
    }

}
