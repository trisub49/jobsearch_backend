package com.farkas.jobsearch.dto;

import java.util.Date;

public class RegistryDTO {

    private Long id;
    private Long jobId;
    private Long employeeId;
    private String employeeName;
    private Date employeeBirthDate;
    private String employeePhoneNumber;
    private String employeeSettlement;
    private String employeePicture;
    private int status;

    public RegistryDTO() {
    }

    public String getEmployeePicture() {
        return employeePicture;
    }
    public void setEmployeePicture(String employeePicture) {
        this.employeePicture = employeePicture;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }
    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeSettlement() {
        return employeeSettlement;
    }
    public void setEmployeeSettlement(String employeeSettlement) {
        this.employeeSettlement = employeeSettlement;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthDate() {
        return employeeBirthDate;
    }
    public void setEmployeeBirthDate(Date employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    public Long getJobId() {
        return jobId;
    }
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}

