package com.farkas.jobsearch.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "JOBS")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    private String adText;

    @JsonBackReference(value = "employer")
    @ManyToOne
    private Employer employer;

    @JsonManagedReference(value = "job")
    @OneToMany(mappedBy = "job")
    private List<Registry> registries;

    private int status;
    private String scope;
    private String category;
    private Date adDate;
    private Date deadline;
    private String settlement;

    private Job() {
    }

    public Employer getEmployer() {
        return employer;
    }
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Registry> getRegistries() {
        return registries;
    }
    public void setRegistries(List<Registry> registries) {
        this.registries = registries;
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
