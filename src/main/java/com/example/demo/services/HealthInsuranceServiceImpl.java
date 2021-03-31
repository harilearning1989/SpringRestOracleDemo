package com.example.demo.services;


import com.example.demo.entity.EmployeeHealthInsurance;
import com.example.demo.exception.InvalidInsuranceAmountException;
import com.example.demo.repos.HealthInsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    @Autowired
    private HealthInsuranceRepo healthInsuranceRepo;

    @Override
    public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
            throws InvalidInsuranceAmountException {

        if (employeeHealthInsurance.getCoverageAmount() < 0) {
            throw new InvalidInsuranceAmountException("Coverage Amount Should not be negative");
        }
        healthInsuranceRepo.save(employeeHealthInsurance);
    }

    @Override
    public void deleteEmployeeHealthInsuranceById(String empid) {
        healthInsuranceRepo.deleteById(1L);
    }

}
