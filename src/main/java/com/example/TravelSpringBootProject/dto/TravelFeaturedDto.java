package com.example.TravelSpringBootProject.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TravelFeaturedDto extends BaseDto {
    @NotNull
    private String featuredName;
    @NotNull
    private Long  travelId;
    public TravelFeaturedDto(){};
    public String getFeaturedName() {
        return featuredName;
    }

    public void setFeaturedName(String featuredName) {
        this.featuredName = featuredName;
    }

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }
}
