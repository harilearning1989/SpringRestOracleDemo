package com.example.demo.repos;

import com.example.demo.entity.CountriesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISortingRepository
        extends PagingAndSortingRepository<CountriesEntity, Long> {

}