package com.example.TravelSpringBootProject.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "travel_schedule")
public class TravelSchedule extends BaseEntity {
    private String dateName;
    @ManyToOne
    @JoinColumn(name= "schedule_travel_details_id")
    private TravelDetails travelDetails;

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }
}
