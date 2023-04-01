package com.example.TravelSpringBootProject.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderDetails {

    @Id
    @Column(name = "order_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;
    private String userName;
    private String travelName;
    private double travelPrice;
    private String peopelQuantity;
    private String status;

    public OrderDetails() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public double getTravelPrice() {
        return travelPrice;
    }

    public void setTravelPrice(double travelPrice) {
        this.travelPrice = travelPrice;
    }

    public String getPeopelQuantity() {
        return peopelQuantity;
    }

    public void setPeopelQuantity(String peopelQuantity) {
        this.peopelQuantity = peopelQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
