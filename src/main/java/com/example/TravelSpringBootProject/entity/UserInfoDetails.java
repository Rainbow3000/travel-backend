package com.example.TravelSpringBootProject.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class UserInfoDetails {
    @Id
    @Column(name = "user_details_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_details_id")
    private User user;

    @Length(min = 10,max = 12)
    private String userIdentify;
    @NotNull
    private String userName;
    @NotNull
    private String phoneNumber;
    private int isVip;

    public UserInfoDetails(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(String userIdentify) {
        this.userIdentify = userIdentify;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIsVip() {
        return isVip;
    }

    public void setIsVip(int isVip) {
        this.isVip = isVip;
    }
}
