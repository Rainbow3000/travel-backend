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
    @Length(min = 2, max = 30,message = "Độ dài danh mục phải lớn hơn >= 2 kí tự")
    @NotNull
    private String categoryName;
    @NotNull(message = "Ảnh phải có giá trị")
    private String categoryImg;
    @NotNull(message = "Trạng thái phải có giá trị")
    private int categoryStatus;
    public CategoryDto(){}

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
