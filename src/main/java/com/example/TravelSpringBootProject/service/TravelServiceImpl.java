package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.Category;
import com.example.TravelSpringBootProject.entity.ImageTravelDetails;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.TravelDetails;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CategoryRepository;
import com.example.TravelSpringBootProject.repository.ImageTravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TravelServiceImpl implements  ITravelService{
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private ImageTravelDetailsRepository imageTravelDetailsRepository;
    @Autowired
    private TravelDetailsRepository travelDetailsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Travel save(Travel travel, TravelDetails travelDetails, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new NotFoundException("category id "+categoryId+" not found !"));
        travel.setCategory(category);
        Travel travelResponse = travelRepository.save(travel);
        ImageTravelDetails imageTravelDetails = new ImageTravelDetails();
        imageTravelDetails.setImage(travel.getTravelImg());
        travelDetails.setTravel(travelResponse);
        travelDetailsRepository.save(travelDetails);
        imageTravelDetailsRepository.save(imageTravelDetails);
        return travelResponse;
    }

    @Override
    public List<Travel> findAll() {
        return travelRepository.findAll();
    }
}
