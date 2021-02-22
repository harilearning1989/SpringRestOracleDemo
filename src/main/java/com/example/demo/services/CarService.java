package com.example.demo.services;

import com.example.demo.entity.Car;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CarService {
    public CompletableFuture<List<Car>> saveCars(InputStream inputStream) throws Exception;

    public CompletableFuture<List<Car>> getAllCars();
}
