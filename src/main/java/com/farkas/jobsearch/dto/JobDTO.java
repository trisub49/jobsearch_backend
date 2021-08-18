package com.farkas.jobsearch.dto;

import java.util.Date;

public class JobDTO {

    private Long id;
    private String adText;
    private Long employerId;
    private int status;
    private String scope;
    private String category;
    private Date adDate;
    private Date deadline;
    private String settlement;

    public JobDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public Date getAdDate() {
        return adDate;
    }
    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }

    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
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

}
