package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ScheduleDate extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_date_travels_id")
    @JsonIgnore
    private TravelSchedule travelSchedule;
    private String sessionDateName;

    @OneToMany(mappedBy = "scheduleDate")
    private Set<ScheduleContent> scheduleContent = new HashSet<>();

    public String getSessionDateName() {
        return sessionDateName;
    }

    public void setSessionDateName(String sessionDateName) {
        this.sessionDateName = sessionDateName;
    }

    public TravelSchedule getTravelSchedule() {
        return travelSchedule;
    }

    public void setTravelSchedule(TravelSchedule travelSchedule) {
        this.travelSchedule = travelSchedule;
    }

    public Set<ScheduleContent> getScheduleContent() {
        return scheduleContent;
    }

    public void setScheduleContent(Set<ScheduleContent> scheduleContent) {
        this.scheduleContent = scheduleContent;
    }
}
