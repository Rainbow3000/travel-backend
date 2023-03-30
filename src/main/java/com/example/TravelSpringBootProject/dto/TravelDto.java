package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.Category;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Component
public class TravelDto extends BaseDto {
    @Length(min = 5, max = 256)
    @NotNull
    private String travelName;

    private String travelImg;

    @NotNull
    private double travelPrice;
    @NotNull
    private int travelStatus;
    @NotNull
    private int travelViewQuantity;
    @NotNull
    private int travelOrderQuantity;
    private String travelDesc;
    private String travelAddress;
    @NotNull
    private Long categoryId;
    private Category category;

    public TravelDto() {}


    @NotNull
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

    public double getTravelPrice() {
        return travelPrice;
    }

    public void setTravelPrice(double travelPrice) {
        this.travelPrice = travelPrice;
    }

    public int getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(int travelStatus) {
        this.travelStatus = travelStatus;
    }

    public int getTravelViewQuantity() {
        return travelViewQuantity;
    }

    public void setTravelViewQuantity(int travelViewQuantity) {
        this.travelViewQuantity = travelViewQuantity;
    }

    public int getTravelOrderQuantity() {
        return travelOrderQuantity;
    }

    public void setTravelOrderQuantity(int travelOrderQuantity) {
        this.travelOrderQuantity = travelOrderQuantity;
    }

    public String getTravelDesc() {
        return travelDesc;
    }

    public void setTravelDesc(String travelDesc) {
        this.travelDesc = travelDesc;
    }

    public String getTravelAddress() {
        return travelAddress;
    }

    public void setTravelAddress(String travelAddress) {
        this.travelAddress = travelAddress;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
