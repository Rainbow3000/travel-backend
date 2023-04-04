package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.TravelDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;

public class TravelPriceTableDto extends BaseDto {
    private Date dateStart;
    @NotNull
    private String typeTransport;
    @NotNull
    private double price;

    @NotNull
    @NotEmpty
    private String place;
    @NotNull
    private Long travelDetailsId;

    public TravelPriceTableDto() {

    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(String typeTransport) {
        this.typeTransport = typeTransport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getTravelDetailsId() {
        return travelDetailsId;
    }

    public void setTravelDetailsId(Long travelDetailsId) {
        this.travelDetailsId = travelDetailsId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
