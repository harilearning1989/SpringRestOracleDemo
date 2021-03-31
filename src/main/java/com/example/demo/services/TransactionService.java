package com.example.demo.services;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.EmployeeHealthInsurance;
import com.example.demo.exception.InvalidInsuranceAmountException;

import java.util.List;

public interface TransactionService {
    List<EmployeeEntity> getAllEmployeeEntity();

    public void joinOrganization(EmployeeEntity employee, EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException;

    public void joinOrganizationRollBack(EmployeeEntity employee, EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException;

    public void leaveOrganization(EmployeeEntity employee, EmployeeHealthInsurance employeeHealthInsurance);

    EmployeeEntity updateEmp(EmployeeDTO dtoToEntity);
}
