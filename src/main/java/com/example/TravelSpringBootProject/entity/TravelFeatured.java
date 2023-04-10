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
    @JoinColumn(name = "featured_travel_id")
    @JsonIgnore
    private Travel travel;
    public TravelFeatured(){};
    public String getFeaturedName() {
        return featuredName;
    }

    public void setFeaturedName(String featuredName) {
        this.featuredName = featuredName;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
