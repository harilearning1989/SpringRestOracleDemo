package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "STUDENT_ID")
    private long studentId;
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MOBILE")
    private long mobile;
    @Column(name = "CATEGORY")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "STUD_ID", referencedColumnName = "STUDENT_ID")
    private Set<IndiaStates> indiaStates;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<IndiaStates> getIndiaStates() {
        return indiaStates;
    }

    public void setIndiaStates(Set<IndiaStates> indiaStates) {
        this.indiaStates = indiaStates;
    }
}

