package com.example.demo.dao;

import com.example.demo.entity.CropInsurance;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CriteriaDAO implements ICriteriaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CropInsurance> getByMandal(String mandal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CropInsurance> cq = cb.createQuery(CropInsurance.class);

        Root<CropInsurance> crop = cq.from(CropInsurance.class);
        List<Predicate> predicates = new ArrayList<>();

        if (mandal != null) {
            predicates.add(cb.equal(crop.get("mandalName"), mandal));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        List<CropInsurance> cropList = em.createQuery(cq).getResultList();
        return cropList;
    }

    @Override
    public List<CropInsurance> getByMandalAndCrop(String mandal, String crop) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CropInsurance> cq = cb.createQuery(CropInsurance.class);

        Root<CropInsurance> root = cq.from(CropInsurance.class);
        List<Predicate> predicates = new ArrayList<>();

        if (mandal != null) {
            predicates.add(cb.equal(root.get("mandalName"), mandal));
        }
        if (crop != null) {
            predicates.add(cb.equal(root.get("crop"), crop));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        List<CropInsurance> cropList = em.createQuery(cq).getResultList();
        return cropList;
    }

    public List<CropInsurance> getByMandalOrCrop(String mandal, String crop) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CropInsurance> cq = cb.createQuery(CropInsurance.class);
        Root<CropInsurance> itemRoot = cq.from(CropInsurance.class);

        Predicate mandalPred = cb.equal(itemRoot.get("mandalName"), mandal);
        Predicate cropPred = cb.equal(itemRoot.get("crop"), crop);
        Predicate mandalAndCrop = cb.or(mandalPred, cropPred);

        cq.where(mandalAndCrop);
        List<CropInsurance> items = em.createQuery(cq).getResultList();

    /*    Predicate predicateForBlueColor = criteriaBuilder.equal(itemRoot.get("color"), "red");
        Predicate predicateForGradeA = criteriaBuilder.equal(itemRoot.get("grade"), "D");
        Predicate predicateForBlueColorAndGradeA = criteriaBuilder.and(predicateForBlueColor, predicateForGradeA);

        Predicate predicateForRedColor = criteriaBuilder.equal(itemRoot.get("color"), "blue");
        Predicate predicateForGradeB = criteriaBuilder.equal(itemRoot.get("grade"), "B");
        Predicate predicateForRedColorAndGradeB = criteriaBuilder.and(predicateForRedColor, predicateForGradeB);

        Predicate finalPredicate = criteriaBuilder.or(predicateForBlueColorAndGradeA, predicateForRedColorAndGradeB);
        criteriaQuery.where(finalPredicate);
        List<Item> items = entityManager.createQuery(criteriaQuery).getResultList();*/

        return items;
    }

}
