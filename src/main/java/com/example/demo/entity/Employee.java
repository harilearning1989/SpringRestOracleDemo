package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idSequence")
    //@SequenceGenerator(name = "idSequence", sequenceName = "EMP_SEQ", allocationSize = 1)
    @Column(name = "EMP_ID")
    @ApiModelProperty(value = "Employee Id")
    private Long id;
    @ApiModelProperty(value = "Employee First Name")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @ApiModelProperty(value = "Employee Last Name")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @ApiModelProperty(value = "Employee Email Id")
    @Column(name = "email_address", nullable = false)
    private String emailId;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}