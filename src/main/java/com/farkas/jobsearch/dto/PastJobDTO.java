package com.farkas.jobsearch.dto;

import com.farkas.jobsearch.domain.Employee;

import javax.persistence.*;

public class PastJobDTO {

    private Long id;
    private Long employeeId;
    private String job;
    private String date;
    private String scope;

    public PastJobDTO() {
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

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
}
