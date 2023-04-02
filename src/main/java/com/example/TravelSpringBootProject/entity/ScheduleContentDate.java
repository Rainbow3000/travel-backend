package com.example.TravelSpringBootProject.entity;

import javax.persistence.*;

@Entity
public class ScheduleContentDate extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "schedule_content_travels")
    private TravelSchedule travelSchedule;
    private String sessionDateName;

    @Column(columnDefinition = "TEXT")
    private String content;
    public String getSessionDateName() {
        return sessionDateName;
    }

    public void setSessionDateName(String sessionDateName) {
        this.sessionDateName = sessionDateName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TravelSchedule getTravelSchedule() {
        return travelSchedule;
    }

    public void setTravelSchedule(TravelSchedule travelSchedule) {
        this.travelSchedule = travelSchedule;
    }
}
