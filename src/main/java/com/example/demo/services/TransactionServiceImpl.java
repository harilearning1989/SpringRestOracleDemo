package com.example.demo.services;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.EmployeeHealthInsurance;
import com.example.demo.exception.InvalidInsuranceAmountException;
import com.example.demo.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    HealthInsuranceService healthInsuranceService;

    @Override
    public List<EmployeeEntity> getAllEmployeeEntity() {
        return employeeRepo.findAll();
    }

    @Override
    @Transactional
    public void joinOrganization(EmployeeEntity employee, EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException {
        employeeRepo.save(employee);
        try {
            healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
        } catch (InvalidInsuranceAmountException e) {
            throw new InvalidInsuranceAmountException("Exception is thrown");
        }
    }

    @Override
    @Transactional(rollbackFor = InvalidInsuranceAmountException.class)
    public void joinOrganizationRollBack(EmployeeEntity employee, EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException {
        employeeRepo.save(employee);
        try {
            healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
        } catch (InvalidInsuranceAmountException e) {
            throw new InvalidInsuranceAmountException("Exception is thrown");
        }
    }

    @Override
    public void leaveOrganization(EmployeeEntity employee, EmployeeHealthInsurance employeeHealthInsurance) {
        employeeRepo.deleteById(1);
        healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
    }

    @Override
    @Transactional(rollbackFor = NullPointerException.class,
            noRollbackFor = EntityNotFoundException.class)
    public EmployeeEntity updateEmp(EmployeeDTO dto) {
        EmployeeEntity entity = employeeRepo.findById(1).get();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setCounty(dto.getCounty());
        entity.setCity(dto.getCity());
        System.out.println(1/0);
        entity.setCompanyName(dto.getCompanyName());
        entity.setState(dto.getState());
        entity.setZip(dto.getZip());
        return entity;
    }
}
