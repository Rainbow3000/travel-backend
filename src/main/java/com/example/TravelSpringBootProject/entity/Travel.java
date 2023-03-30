package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "travels")
public class Travel extends BaseEntity implements Serializable {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public Travel() {}



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
