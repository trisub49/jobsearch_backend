package com.farkas.jobsearch.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EMPLOYERS")
public class Employer extends Person {

    @Column(unique = true)
    private String company;

    @Column(length = 1024)
    private String description;

    @JsonManagedReference(value = "employer")
    @OneToMany(mappedBy = "employer")
    List<Job> jobs;

    private Employer() {
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
