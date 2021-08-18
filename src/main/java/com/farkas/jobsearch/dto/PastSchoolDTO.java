package com.farkas.jobsearch.dto;

import com.farkas.jobsearch.domain.Employee;

import javax.persistence.*;

public class PastSchoolDTO {

    private Long id;
    private Long employeeId;
    private String school;
    private String date;
    private String education;

    public PastSchoolDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
}
