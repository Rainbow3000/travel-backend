package com.example.TravelSpringBootProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private OrderDetails orderDetails;

    public Order() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
