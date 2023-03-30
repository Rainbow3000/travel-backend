package com.example.TravelSpringBootProject.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public abstract class BaseDto {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String modifyBy;
    private String createdBy;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
