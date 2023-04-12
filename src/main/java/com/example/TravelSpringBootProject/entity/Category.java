package com.example.TravelSpringBootProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorys")
public class Category extends BaseEntity{
    @Length(min = 2, max = 30,message = "Độ dài danh mục phải lớn hơn >= 2 kí tự")
    @NotNull
    private String categoryName;
    @NotNull(message = "Ảnh phải có giá trị")
    private String categoryImg;
    @NotNull(message = "Trạng thái phải có giá trị")
    private int categoryStatus;
    public Category(){}

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
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

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

}
