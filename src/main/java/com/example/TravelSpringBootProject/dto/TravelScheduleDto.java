package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.ScheduleDate;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class TravelScheduleDto extends BaseDto {

    @NotNull
    private String dateName;

    private Set<ScheduleDate> scheduleDates = new HashSet<>();
    @NotNull
    private Long travelId;

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public Set<ScheduleDate> getScheduleDates() {
        return scheduleDates;
    }

    public void setScheduleDates(Set<ScheduleDate> scheduleDates) {
        this.scheduleDates = scheduleDates;
    }

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }
}
