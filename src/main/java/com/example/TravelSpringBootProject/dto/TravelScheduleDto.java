package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.entity.TravelDetails;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class TravelScheduleDto extends BaseDto {

    @NotNull
    private String dateName;

    private Set<ScheduleDate> scheduleDates = new HashSet<>();
    @NotNull
    private Long travelDetailsId;

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public Long getTravelDetailsId() {
        return travelDetailsId;
    }

    public void setTravelDetailsId(Long travelDetailsId) {
        this.travelDetailsId = travelDetailsId;
    }

    public Set<ScheduleDate> getScheduleDates() {
        return scheduleDates;
    }

    public void setScheduleDates(Set<ScheduleDate> scheduleDates) {
        this.scheduleDates = scheduleDates;
    }


}
