package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.Category;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CategoryRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TravelServiceImpl implements  ITravelService{
    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Travel save(Travel travel,Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new NotFoundException("category id "+categoryId+" not found !"));
        travel.setCategory(category);
        return travelRepository.save(travel);
    }

    @Override
    public List<Travel> findAll() {
        return travelRepository.findAll();
    }
}
