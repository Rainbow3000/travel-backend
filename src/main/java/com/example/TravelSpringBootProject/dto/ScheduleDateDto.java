package com.example.TravelSpringBootProject.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ScheduleDateDto extends BaseDto {
    @NotNull
    private String sessionDateName;
    @NotNull
    private Long travelScheduleId;
    public String getSessionDateName() {
        return sessionDateName;
    }

    public void setSessionDateName(String sessionDateName) {
        this.sessionDateName = sessionDateName;
    }

    public Long getTravelScheduleId() {
        return travelScheduleId;
    }

    public void setTravelScheduleId(Long travelScheduleId) {
        this.travelScheduleId = travelScheduleId;
    }
}
