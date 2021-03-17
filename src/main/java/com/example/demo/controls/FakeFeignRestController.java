package com.example.demo.controls;

import com.example.demo.dto.Countries;
import com.example.demo.dto.PostDTO;
import com.example.demo.feign.CountriesFeignClient;
import com.example.demo.feign.JSONPlaceHolderClient;
import com.example.demo.multiThread.CallableExample;
import com.example.demo.multiThread.CountriesCallable;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/fake")
@Api(value = "FakeFeignRestController")
public class FakeFeignRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeFeignRestController.class);

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;
    @Autowired
    private CountriesFeignClient countriesFeignClient;
    @Autowired
    private CallableExample callableExample;
    @Autowired
    private CountriesCallable countriesCallable;

    @RequestMapping(value = "/countriesSingleThread", method = RequestMethod.GET)
    public Integer countriesSingleThread() {
        LOGGER.info("getAllCountries===");
        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 5000)
                .forEach(i -> {
                    List<Countries> posts = countriesFeignClient.getAllCountries();
                });
        //.forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        int duration = (int) (endTime - startTime);
        return duration;
    }

    @RequestMapping(value = "/countriesMultiThread", method = RequestMethod.GET)
    public Integer countriesMultiThread() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<List<Countries>>> list = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        IntStream.rangeClosed(1, 5000)
                .forEach(i -> {
                    Future<List<Countries>> futureList = executorService.submit(countriesCallable);
                    list.add(futureList);
                });
        for (Future<List<Countries>> future : list) {
            future.get();
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        int duration = (int) (endTime - startTime);
        return duration;
    }

    @RequestMapping(value = "/covidSingleThread", method = RequestMethod.GET)
    public Integer covidSingleThread() {
        LOGGER.info("getAllPosts===");
        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    List<PostDTO> posts = jsonPlaceHolderClient.getCovidData();
                });
        //.forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        int duration = (int) (endTime - startTime);
        return duration;
    }

    @RequestMapping(value = "/covidMultiThread", method = RequestMethod.GET)
    public Integer covidMultiThread() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<List<PostDTO>>> list = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    Future<List<PostDTO>> futureList = executorService.submit(callableExample);
                    list.add(futureList);
                });
        for (Future<List<PostDTO>> future : list) {
            future.get();
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        int duration = (int) (endTime - startTime);
        return duration;
    }
}
