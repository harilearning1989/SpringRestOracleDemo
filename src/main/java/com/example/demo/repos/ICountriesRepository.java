package com.example.demo.repos;

import com.example.demo.entity.Countries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountriesRepository extends CrudRepository<Countries, Integer>{

    public List<Countries> findByIntRegionNull();
    public List<Countries> findByIntRegionNotNull();

}
