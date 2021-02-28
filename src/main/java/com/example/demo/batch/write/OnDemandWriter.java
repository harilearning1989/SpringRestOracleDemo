package com.example.demo.batch.write;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class OnDemandWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> messages) throws Exception {
        for (String msg : messages) {
            System.out.println("Writing the data " + msg);
        }
    }
}