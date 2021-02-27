package com.example.demo.batch.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "step")
@Component("onDemandProcessor")
public class OnDemandProcessor implements ItemProcessor<String, String> {

    @Value("#{jobParameters['fileName']}")
    private String fileName;

    @Override
    public String process(String data) throws Exception {
        System.out.println("Job parameter:" + fileName);
        return data.toUpperCase();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
