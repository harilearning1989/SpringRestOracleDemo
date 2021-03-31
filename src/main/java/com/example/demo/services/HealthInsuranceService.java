package com.example.demo.services;

import com.example.demo.entity.EmployeeHealthInsurance;
import com.example.demo.exception.InvalidInsuranceAmountException;

public interface HealthInsuranceService {
    void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException;

    void deleteEmployeeHealthInsuranceById(String empid);
}
