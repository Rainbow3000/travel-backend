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
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String travelDescription ;
    @NotNull
    private String travelAddress;
    @NotNull
    private String travelDateNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "travel",cascade = CascadeType.ALL)
    private Set<TravelPriceTable> travelPriceTables = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "travel",cascade = CascadeType.ALL)
    private Set<TravelFeatured> travelFeatureds = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "travel",cascade = CascadeType.ALL)
    private Set<TravelSchedule> travelSchedules = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "travel",cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "travel",cascade = CascadeType.ALL)
    private Set<ImageTravel> imageTravels = new HashSet<>();

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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
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



    public String getTravelDescription() {
        return travelDescription;
    }

    public void setTravelDescription(String travelDescription) {
        this.travelDescription = travelDescription;
    }

    public Set<ImageTravel> getImageTravels() {
        return imageTravels;
    }

    public void setImageTravels(Set<ImageTravel> imageTravels) {
        this.imageTravels = imageTravels;
    }

    public String getTravelAddress() {
        return travelAddress;
    }

    public void setTravelAddress(String travelAddress) {
        this.travelAddress = travelAddress;
    }

    public String getTravelDateNumber() {
        return travelDateNumber;
    }

    public void setTravelDateNumber(String travelDateNumber) {
        this.travelDateNumber = travelDateNumber;
    }

    public Set<TravelFeatured> getTravelFeatureds() {
        return travelFeatureds;
    }

    public void setTravelFeatureds(Set<TravelFeatured> travelFeatureds) {
        this.travelFeatureds = travelFeatureds;
    }

    public Set<TravelSchedule> getTravelSchedules() {
        return travelSchedules;
    }

    public void setTravelSchedules(Set<TravelSchedule> travelSchedules) {
        this.travelSchedules = travelSchedules;
    }

    public Set<TravelPriceTable> getTravelPriceTables() {
        return travelPriceTables;
    }

    public void setTravelPriceTables(Set<TravelPriceTable> travelPriceTables) {
        this.travelPriceTables = travelPriceTables;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


}
