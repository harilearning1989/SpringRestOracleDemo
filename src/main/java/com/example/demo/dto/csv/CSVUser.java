package com.example.demo.dto.csv;


import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Data
@Getter
@Setter
public class CSVUser {

    public CSVUser(){

    }
    public CSVUser(String name,String email,String phoneNo,String country){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }
    @CsvBindByName
    //@CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCountry() {
        return country;
    }
}
