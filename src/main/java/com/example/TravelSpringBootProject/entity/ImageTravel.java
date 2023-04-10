package com.example.TravelSpringBootProject.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImageTravel extends BaseEntity {
    private String image ;
    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
