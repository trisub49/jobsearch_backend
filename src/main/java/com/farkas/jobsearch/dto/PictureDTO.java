package com.farkas.jobsearch.dto;

public class PictureDTO {

    String pictureCode;

    public String getPictureCode() {
        return pictureCode;
    }
    public void setPictureCode(String pictureCode) {
        this.pictureCode = pictureCode;
    }

    public PictureDTO(String pictureCode) {
        this.pictureCode = pictureCode;
    }
    public PictureDTO() {
    }
}
