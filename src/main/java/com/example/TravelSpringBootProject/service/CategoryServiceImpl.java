package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.Category;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);

    }

    @Override
    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new NotFoundException("category id "+id +" not found !");
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
