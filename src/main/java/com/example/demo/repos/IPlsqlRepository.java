package com.example.demo.repos;

import com.example.demo.entity.CropInsurance;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlsqlRepository extends CrudRepository<CropInsurance, Integer> {

    @Procedure(name = "in_only_test_crop")
    void inOnlyTest(@Param("inParam1") String inParam1);

    @Procedure(name = "in_and_out_test_crop")
    String inAndOutTest(@Param("inParam1") String inParam1);

    @Procedure(name = CropInsurance.NamedQuery_FetchCropInsurance)
    List<CropInsurance> fetchCropInsuranceProcCursor();

    @Query(nativeQuery = true, value = "select practiced_pkg.get_array_func() from dual")
    List<String> getArrayFunc();

    @Query(nativeQuery = true, value = "select practiced_pkg.get_array_func() from dual;")
    String singleString();

    @Procedure
    List<CropInsurance> findCropsViaProcedure();

}
