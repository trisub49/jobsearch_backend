package com.farkas.jobsearch.dto;

import java.util.Date;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String settlement;
    private String picture;
    private String pictureName;
    private int status;
    private Date birthDate;

    public EmployeeDTO() {
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

    public String getPictureName() {
        return pictureName;
    }
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
