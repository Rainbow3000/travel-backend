package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.dto.CategoryDto;
import com.example.TravelSpringBootProject.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    Category save(Category category);
    Category findById(Long id);
    List<Category> findAll();
}
