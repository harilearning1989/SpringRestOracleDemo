package com.example.demo.config;

import com.example.demo.intercept.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class LoggerAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ApiLogger productServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
    }

}

