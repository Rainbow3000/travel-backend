package com.example.TravelSpringBootProject.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class TravelPriceTable extends BaseEntity{
    private Date dateStart;
    private String typeTransport;
    private double price;

    @ManyToOne
    @JoinColumn(name = "price_table_travel_details")
    private TravelDetails travelDetails;

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

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }
}
