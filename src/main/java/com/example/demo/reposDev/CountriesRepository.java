package com.example.demo.reposDev;

import com.example.demo.entity.Countries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends CrudRepository<Countries, Integer> {

    public List<Countries> findByIntRegionNull();

    public List<Countries> findByIntRegionNotNull();

}