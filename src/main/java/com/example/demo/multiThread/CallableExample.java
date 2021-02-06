package com.example.demo.multiThread;

import com.example.demo.dto.PostDTO;
import com.example.demo.feign.JSONPlaceHolderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;

@Component
public class CallableExample implements Callable<List<PostDTO>> {

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;

    @Override
    public List<PostDTO> call() throws Exception {
        return jsonPlaceHolderClient.getCovidData();
    }
}
