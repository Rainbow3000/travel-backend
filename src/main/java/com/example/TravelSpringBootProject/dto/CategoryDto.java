package com.example.TravelSpringBootProject.dto;

import com.example.TravelSpringBootProject.entity.Travel;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Component
public class CategoryDto extends BaseDto {
    @Length(min = 5, max = 256)
    @NotNull
    private String categoryName;
    private String categoryImage;
    private String categoryDesc;
    private int categoryStatus;
    public CategoryDto(){}

    private Set<Travel> travel = new HashSet<>();

    public Set<Travel> getTravel() {
        return travel;
    }

    public void setTravel(Set<Travel> travel) {
        this.travel = travel;
    }

    public int getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(int categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
}
