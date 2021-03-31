package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeHealthInsurance")
public class EmployeeHealthInsurance {

    @Id
    @Column(name = "empId")
    private String empId;
    @Column(name = "healthInsuranceSchemeName")
    private String healthInsuranceSchemeName;
    @Column(name = "coverageAmount")
    private int coverageAmount;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getHealthInsuranceSchemeName() {
        return healthInsuranceSchemeName;
    }

    public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
        this.healthInsuranceSchemeName = healthInsuranceSchemeName;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

}
