package com.farkas.jobsearch.dto;

public class RegistryWithJobDataDTO {

    private Long id;
    private Long jobId;
    private Long employeeId;
    private String jobName;
    private String jobCompany;
    private String jobSettlement;

    public String getJobCompany() {
        return jobCompany;
    }
    public void setJobCompany(String jobCompany) {
        this.jobCompany = jobCompany;
    }

    public String getJobSettlement() {
        return jobSettlement;
    }
    public void setJobSettlement(String jobSettlement) {
        this.jobSettlement = jobSettlement;
    }

    private int status;

    public RegistryWithJobDataDTO() {
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

    public Long getJobId() {
        return jobId;
    }
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
