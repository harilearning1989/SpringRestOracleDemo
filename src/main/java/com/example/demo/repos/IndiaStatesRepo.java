package com.example.demo.repos;

import com.example.demo.entity.IndiaStates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndiaStatesRepo extends JpaRepository<IndiaStates, Integer> {
    public List<IndiaStates> findByStateNameIgnoreCase(String state);
}
