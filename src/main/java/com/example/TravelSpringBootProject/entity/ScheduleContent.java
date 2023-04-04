package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ScheduleContent extends BaseEntity{
    private String content;
    @ManyToOne
    @JoinColumn(name= "schedule_content_schedule_date_id")
    @JsonIgnore
    private ScheduleDate scheduleDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ScheduleDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(ScheduleDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
