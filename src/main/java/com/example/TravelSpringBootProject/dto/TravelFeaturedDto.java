package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.TravelDetails;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TravelFeaturedDto extends BaseDto {
    @NotNull
    private String featuredName;
    @NotNull
    @NotEmpty
    private String  travelDetailsId;
    public TravelFeaturedDto(){};
    public String getFeaturedName() {
        return featuredName;
    }

    public void setFeaturedName(String featuredName) {
        this.featuredName = featuredName;
    }

    public String getTravelDetailsId() {
        return travelDetailsId;
    }

    public void setTravelDetailsId(String travelDetailsId) {
        this.travelDetailsId = travelDetailsId;
    }
}
