package com.example.demo.repos;

import com.example.demo.entity.MyTable;
import feign.Param;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface IMyTableRepository extends CrudRepository<MyTable, Long> {

    @Procedure(name = "in_only_test")
    void inOnlyTest(@Param("inParam1") String inParam1);

    @Procedure(name = "in_and_out_test")
    String inAndOutTest(@Param("inParam1") String inParam1);
}
