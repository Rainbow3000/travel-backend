package com.example.TravelSpringBootProject.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImageTravelDetails extends BaseEntity {
    private String image ;
    @ManyToOne
    @JoinColumn(name = "travel_details_id")
    private TravelDetails travelDetails;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }
}
