package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.Category;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Component
public class TravelDto extends BaseDto {
    @Length(min = 5, max = 256)
    @NotNull
    private String travelName;
    private String travelImg;
    @NotNull
    private double travelPriceNew;
    @NotNull
    private String travelDescription;
    @NotNull
    private double travelPriceOld;
    @NotNull
    private int travelStatus;
    private String travelAddress;
    @NotNull
    private String travelDateNumber;

    @NotNull
    private Long categoryId;

    public TravelDto() {}

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getTravelImg() {
        return travelImg;
    }

    public void setTravelImg(String travelImg) {
        this.travelImg = travelImg;
    }

    public double getTravelPriceOld() {
        return travelPriceOld;
    }

    public void setTravelPriceOld(double travelPriceOld) {
        this.travelPriceOld = travelPriceOld;
    }

    public String getTravelDateNumber() {
        return travelDateNumber;
    }

    public void setTravelDateNumber(String travelDateNumber) {
        this.travelDateNumber = travelDateNumber;
    }

    public int getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(int travelStatus) {
        this.travelStatus = travelStatus;
    }


    public String getTravelAddress() {
        return travelAddress;
    }

    public void setTravelAddress(String travelAddress) {
        this.travelAddress = travelAddress;
    }

    public double getTravelPriceNew() {
        return travelPriceNew;
    }

    public void setTravelPriceNew(double travelPriceNew) {
        this.travelPriceNew = travelPriceNew;
    }

    public String getTravelDescription() {
        return travelDescription;
    }

    public void setTravelDescription(String travelDescription) {
        this.travelDescription = travelDescription;
    }


}
