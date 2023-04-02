package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "travels")
public class Travel extends BaseEntity implements Serializable {
    @Length(min = 5, max = 256)
    @NotNull
    private String travelName;

    private String travelImg;

    @NotNull
    private double travelPriceNew;

    @NotNull
    private double travelPriceOld;
    @NotNull
    private int travelStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
    @OneToOne(mappedBy = "travel",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TravelDetails travelDetails;
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

    public double getTravelPriceNew() {
        return travelPriceNew;
    }

    public void setTravelPriceNew(double travelPriceNew) {
        this.travelPriceNew = travelPriceNew;
    }

    public double getTravelPriceOld() {
        return travelPriceOld;
    }

    public void setTravelPriceOld(double travelPriceOld) {
        this.travelPriceOld = travelPriceOld;
    }

    public int getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(int travelStatus) {
        this.travelStatus = travelStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public TravelDetails getTravelDetails() {
        return travelDetails;
    }
    public void setTravelDetails(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }
}
