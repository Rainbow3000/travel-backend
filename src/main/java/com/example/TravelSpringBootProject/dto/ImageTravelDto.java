package com.example.TravelSpringBootProject.dto;

public class ImageTravelDto extends BaseDto {
    private String image;

    private Long travelId;

    public ImageTravelDto() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }
}
