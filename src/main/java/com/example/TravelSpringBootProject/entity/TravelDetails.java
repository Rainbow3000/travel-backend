package com.example.TravelSpringBootProject.entity;


import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="travel_details")
public class TravelDetails{
    @Id
    @Column(name = "travel_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "travel_id")
    private Travel travel;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String travelDescription ;
    @NotNull
    private String travelAddress;
    @NotNull
    private String travelDateNumber;

    @OneToMany(mappedBy = "travelDetails")
    private Set<Comment> comments = new HashSet<>();

    public TravelDetails() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public String getTravelDescription() {
        return travelDescription;
    }

    public void setTravelDescription(String travelDescription) {
        this.travelDescription = travelDescription;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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

}
