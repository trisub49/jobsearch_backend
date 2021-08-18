package com.farkas.jobsearch.dto;

import com.farkas.jobsearch.domain.PastJob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeWithInfoDTO {

    private Long id;
    private Long registryId;
    private String name;
    private String phoneNumber;
    private String settlement;
    private String picture;
    private int status;
    private Date birthDate;
    private List<PastJobDTO> pastJobs = new ArrayList<>();
    private List<PastSchoolDTO> pastSchools = new ArrayList<>();

    public EmployeeWithInfoDTO() {
    }

    public Long getRegistryId() {
        return registryId;
    }
    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }

    public List<PastJobDTO> getPastJobs() {
        return pastJobs;
    }
    public void setPastJobs(List<PastJobDTO> pastJobs) {
        this.pastJobs = pastJobs;
    }

    public List<PastSchoolDTO> getPastSchools() {
        return pastSchools;
    }
    public void setPastSchools(List<PastSchoolDTO> pastSchools) {
        this.pastSchools = pastSchools;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
