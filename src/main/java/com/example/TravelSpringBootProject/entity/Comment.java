package com.example.TravelSpringBootProject.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String userCommentName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "travel_id")
    private TravelDetails travelDetails;

    private Date commentDate;
    @NotNull
    @Length(max = 100)
    private String content;

    public Comment() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TravelDetails getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(TravelDetails travelDetails) {
        this.travelDetails = travelDetails;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getUserCommentName() {
        return userCommentName;
    }

    public void setUserCommentName(String userCommentName) {
        this.userCommentName = userCommentName;
    }
}
