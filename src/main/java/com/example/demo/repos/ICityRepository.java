package com.example.demo.repos;

import com.example.demo.entity.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {

    @Query("FROM City ORDER BY population ASC")
    List<City> findAllOrderByPopulationAsc();

    @Query("FROM City")
    List<City> findAllOrderByNameAsc(Sort sort);
}
