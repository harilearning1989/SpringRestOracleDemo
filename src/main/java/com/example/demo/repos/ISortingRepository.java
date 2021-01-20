package com.example.demo.repos;

import com.example.demo.entity.Countries;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISortingRepository
        extends PagingAndSortingRepository<Countries, Long> {

}