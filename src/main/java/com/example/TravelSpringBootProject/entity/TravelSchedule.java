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
    @JoinColumn(name= "schedule_travel_id")
    private Travel travel;

    @OneToMany(mappedBy = "travelSchedule")
    private Set<ScheduleDate> scheduleDate = new HashSet<>();

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public Set<ScheduleDate> getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Set<ScheduleDate> scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
