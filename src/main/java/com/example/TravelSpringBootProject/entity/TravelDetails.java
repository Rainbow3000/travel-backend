package com.example.TravelSpringBootProject.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TravelDetails{
    @Id
    @Column(name = "travel_id")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "travel_id")
    private Travel travel;

    @NotNull
    private String desc ;

    private String imageDetail;

    @OneToMany(mappedBy = "travelDetails")
    private Set<Comment> comments = new HashSet<>();

    public TravelDetails() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(String imageDetail) {
        this.imageDetail = imageDetail;
    }


    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


}
