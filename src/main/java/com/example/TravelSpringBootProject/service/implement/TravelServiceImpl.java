package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.Category;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CategoryRepository;
import com.example.TravelSpringBootProject.repository.ImageTravelRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.service.interfaces.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TravelServiceImpl implements ITravelService {
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private ImageTravelRepository imageTravelRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Travel save(Travel travelRequest,Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new NotFoundException("Not found category id"));
        travelRequest.setCategory(category);
        return travelRepository.save(travelRequest);
    }

    @Override
    public List<Travel> findAll() {
        return travelRepository.findAll();
    }

    @Override
    public Set<Travel> findAllByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new NotFoundException("category id "+categoryId+" not found !"));

        return category.getTravel();
    }

    @Override
    public Boolean update(Travel travelRequest, Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        travel.setTravelName(travelRequest.getTravelName());
        travel.setTravelDescription(travelRequest.getTravelDescription());
        travel.setTravelImg(travelRequest.getTravelImg());
        travel.setTravelStatus(travelRequest.getTravelStatus());
        travel.setTravelPriceNew(travelRequest.getTravelPriceNew());
        travel.setTravelPriceOld(travelRequest.getTravelPriceOld());
        travel.setTravelDateNumber(travelRequest.getTravelDateNumber());
        travelRepository.save(travel);
        return true;
    }


    @Override
    public Boolean delete(Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        travelRepository.delete(travel);
        return true;
    }
}
