package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.TravelDetails;
import com.example.TravelSpringBootProject.entity.TravelFeatured;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelFeaturedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TravelFeaturedServiceImpl implements ITravelFeaturedService {


    @Autowired
    private TravelFeaturedRepository travelFeaturedRepository;

    @Autowired
    private TravelDetailsRepository travelDetailsRepository;
    @Override
    public TravelFeatured save(TravelFeatured travelFeatured,String travelDetailsId) {

        TravelDetails travelDetails = travelDetailsRepository.findById(Long.valueOf(travelDetailsId)).orElse(null);
        if(travelDetails == null){
            throw new NotFoundException("travel details id: "+ travelDetailsId + " not found");
        }
        travelFeatured.setTravelDetails(travelDetails);

        return travelFeaturedRepository.save(travelFeatured);
    }
}
