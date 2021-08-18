package com.farkas.jobsearch.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class JobWithCompanyDTO {

    private Long id;
    private String adText;
    private String company;
    private Long employerId;
    private int status;
    private String scope;
    private String category;
    private LocalDate adDate;
    private LocalDate deadline;
    private String settlement;
    private String picture;

    public JobWithCompanyDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public Long getEmployerId() {
        return employerId;
    }
    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAdText() {
        return adText;
    }
    public void setAdText(String adText) {
        this.adText = adText;
    }

    public LocalDate getAdDate() {
        return adDate;
    }
    public void setAdDate(LocalDate adDate) {
        this.adDate = adDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getSettlement() {
        return settlement;
    }
    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
