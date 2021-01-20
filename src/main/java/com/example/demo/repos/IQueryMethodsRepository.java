package com.example.demo.repos;

import com.example.demo.entity.CropInsurance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQueryMethodsRepository extends CrudRepository<CropInsurance, Integer> {
    public List<CropInsurance> findByMandalName(String mandalName);
    public List<CropInsurance> findByMandalNameIgnoreCase(String mandalName);
    public List<CropInsurance> findDistinctByMandalName(String mandalName);

    @Query("select distinct mandalName from CropInsurance")
    public List<String> findMandalNameDistinct();

    @Query(value = "SELECT distinct MANDAL_NAME FROM CROP_INSURANCE", nativeQuery = true)
    public List<String> findMandalName();

    @Query(value = "SELECT count(MANDAL_NAME) FROM CROP_INSURANCE", nativeQuery = true)
    public String countTheVillages();

    @Query(value = "SELECT count(VILLAGE_NAME) FROM CROP_INSURANCE where upper(MANDAL_NAME) = upper(:mandalName) ", nativeQuery = true)
    public String countTheVillagesByMandal(@Param("mandalName") String mandalName);

    public List<CropInsurance> findDistinctByMandalNameAndCrop(String mandalName,String crop);
    public List<CropInsurance> findByMandalNameAndCrop(String mandalName,String crop);
    public List<CropInsurance> findByMandalNameOrCrop(String mandalName,String crop);
    public List<CropInsurance> findByClaimAmountLessThanEqual(int claimAmount);
    public List<CropInsurance> findByClaimAmountGreaterThanEqual(int claimAmount);
    public List<CropInsurance> findByVillNameLike(String villName);
    public List<CropInsurance> findByVillNameNotLike(String villName);
    public List<CropInsurance> findByVillNameStartingWith(String villName);
    public List<CropInsurance> findByVillNameEndingWith(String villName);
    public List<CropInsurance> findByVillNameContaining(String villName);
    public List<CropInsurance> findByMandalNameOrderByVillNameDesc(String mandal);
    public List<CropInsurance> findByMandalNameNot(String mandal);
    public List<CropInsurance> findByClaimAmountInOrderByClaimAmount(List<Integer> claimAmount);
    public List<CropInsurance> findByClaimAmountNotInOrderByClaimAmount(List<Integer> claimAmount);

    @Query("select u from CropInsurance u where u.mandalName like ?1%")
    List<CropInsurance> findByAndSort(String mandalName, Sort sort);

    @Query("select u.mandalName, LENGTH(u.villName) as villName from CropInsurance u where u.mandalName like ?1%")
    List<Object[]> findByAsArrayAndSort(String mandalName, Sort sort);

    /*@Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
    CropInsurance findByLastnameOrFirstname(@Param("lastname") String lastname,
                                   @Param("firstname") String firstname);*/
}
