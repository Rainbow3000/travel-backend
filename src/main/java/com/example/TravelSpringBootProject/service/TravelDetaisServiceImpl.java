package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.*;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TravelDetaisServiceImpl implements ITravelDetailsService{

    @Autowired
    private TravelDetailsRepository travelDetailsRepository;

    @Autowired
    private TravelScheduleRepository travelScheduleRepository;
    @Override
    public Set<TravelFeatured> getAllFeaturedByTravelDetailsId(Long id) {
        TravelDetails travelDetails = travelDetailsRepository.findById(id).orElse(null);
        if(travelDetails == null){
            throw  new NotFoundException("travel details id: "+ id + " not found !");
        }
        return travelDetails.getTravelFeatureds();

    }

    @Override
    public Set<TravelSchedule> getAllScheduleByTravelDetailsId(Long id) {
        TravelDetails travelDetails = travelDetailsRepository.findById(id).orElse(null);
        if(travelDetails == null){
            throw  new NotFoundException("travel details id: "+ id + " not found !");
        }
        return travelDetails.getTravelSchedules();
    }

    @Override
    public Set<TravelPriceTable> getAllPriceTableByTravelDetailsId(Long id) {
        TravelDetails travelDetails = travelDetailsRepository.findById(id).orElse(null);
        if(travelDetails == null){
            throw  new NotFoundException("travel details id: "+ id + " not found !");
        }
        return travelDetails.getTravelPriceTables();
    }

    @Override
    public Set<Comment> getAllCommentByTravelDetailsId(Long id) {
        TravelDetails travelDetails = travelDetailsRepository.findById(id).orElse(null);
        if(travelDetails == null){
            throw  new NotFoundException("travel details id: "+ id + " not found !");
        }
        return travelDetails.getComments() ;
    }
}
