package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.ScheduleDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class ScheduleContentDto extends BaseDto{
    @NotNull
    private String content;

    @NotNull
    private Long scheduleDateId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getScheduleDateId() {
        return scheduleDateId;
    }

    public void setScheduleDateId(Long scheduleDateId) {
        this.scheduleDateId = scheduleDateId;
    }
}
