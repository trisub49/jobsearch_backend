package com.farkas.jobsearch.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends Person {

    private int status;
    private Date birthDate;

    @JsonBackReference(value = "employee")
    @OneToMany(mappedBy = "employee")
    List<Registry> registries;

    private Employee() {
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

    public List<Registry> getRegistries() {
        return registries;
    }
    public void setRegistries(List<Registry> registries) {
        this.registries = registries;
    }
}
