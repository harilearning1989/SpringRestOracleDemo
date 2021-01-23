package com.example.demo.reposDev;

import com.example.demo.entity.LaserSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaserSearchRepository extends JpaRepository<LaserSearch, Long> {
    List<LaserSearch> findByServiceIdContaining(String title);
}
