package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TravelFeatured extends BaseEntity {

    @JoinColumn(columnDefinition = "TEXT")
    private String featuredName;
    @ManyToOne
    @JoinColumn(name = "featured_travel_details_id")
    @JsonIgnore
    private TravelDetails travelDetails;
    public TravelFeatured(){};
    public String getFeaturedName() {
        return featuredName;
    }

    public void setFeaturedName(String featuredName) {
        this.featuredName = featuredName;
    }

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }


}
