package com.example.demo.feign;

import com.example.demo.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "covidData", url = "https://api.covidtracking.com/v1/us/")
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.GET, value = "daily.json")
    List<PostDTO> getCovidData();

    /*@RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    PostDTO getPostById(@PathVariable("postId") Long postId);*/
}
