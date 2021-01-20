package com.example.demo.services;

import com.example.demo.entity.Countries;
import com.example.demo.repos.ISortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private ISortingRepository repository;

    public List<Countries> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Countries> pagedResult = repository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Countries> getAllEmployeesDescending(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Countries> pagedResult = repository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Countries> getEmpPagingOnly(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Countries> pagedResult = repository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Countries> getEmpSortingOnly(String first,String second) {
        Sort emailSort = Sort.by(first);
        Sort firstNameSort = Sort.by(second);
        Sort groupBySort = emailSort.and(firstNameSort);
        List<Countries> list = (List<Countries>) repository.findAll(groupBySort);
        return list;
    }

    public List<Countries> getEmpSortOrder(){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        Sort.Order nameSort = new Sort.Order(Sort.Direction.DESC, "region");
        orders.add(nameSort);
        Sort.Order regionSort = new Sort.Order(Sort.Direction.ASC, "name");
        orders.add(regionSort);

        List<Countries> countriesList = (List<Countries>) repository.findAll(Sort.by(orders));
        return countriesList;
    }

    public List<Countries> getEmpSortNullsLast(){
        Sort.Order nameSort = new Sort.Order(Sort.Direction.DESC, "region").nullsLast();
        List<Countries> countriesList = (List<Countries>) repository.findAll(Sort.by(nameSort));
        return countriesList;
    }
    public List<Countries> getEmpSortNullsFirst(){
        Sort.Order nameSort = new Sort.Order(Sort.Direction.DESC, "region").nullsFirst();
        List<Countries> countriesList = (List<Countries>) repository.findAll(Sort.by(nameSort));
        return countriesList;
    }

}
