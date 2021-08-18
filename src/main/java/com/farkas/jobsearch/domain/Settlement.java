package com.farkas.jobsearch.domain;

import javax.persistence.*;

@Entity
@Table(name = "SETTLEMENTS")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int postcode;
    private String name;
    private String county;
    private float height;
    private float width;
    private float range;

    private Settlement() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getPostcode() {
        return postcode;
    }
    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }

    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }

    public float getRange() {
        return range;
    }
    public void setRange(float range) {
        this.range = range;
    }
}
