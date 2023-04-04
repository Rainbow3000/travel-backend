package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "travel_schedule")
public class TravelSchedule extends BaseEntity {
    @NotNull
    private String dateName;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "schedule_travel_details_id")
    private TravelDetails travelDetails;

    @OneToMany(mappedBy = "travelSchedule")
    private Set<ScheduleDate> scheduleDate = new HashSet<>();

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

    public Set<ScheduleDate> getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Set<ScheduleDate> scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
