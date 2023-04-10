package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.TravelFeatured;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelFeaturedRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.service.interfaces.ITravelFeaturedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class TravelFeaturedServiceImpl implements ITravelFeaturedService {


    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private TravelFeaturedRepository travelFeaturedRepository;

    @Override
    public TravelFeatured save(TravelFeatured travelFeatured,Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        travelFeatured.setTravel(travel);
        return travelFeaturedRepository.save(travelFeatured);
    }

    @Override
    public Set<TravelFeatured> findByTravelId(Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        return travel.getTravelFeatureds();
    }

    @Override
    public Boolean update(TravelFeatured travelFeaturedRequest, Long featuredId) {
        TravelFeatured travelFeatured = travelFeaturedRepository.findById(featuredId).orElseThrow(()-> new NotFoundException("Not found featured id"));
        travelFeatured.setFeaturedName(travelFeaturedRequest.getFeaturedName());
        travelFeaturedRepository.save(travelFeatured);
        return true;
    }

    @Override
    public Boolean delete(Long featuredId) {
        TravelFeatured travelFeatured =  travelFeaturedRepository.findById(featuredId).orElseThrow(()-> new NotFoundException("Not found featured id"));
        travelFeaturedRepository.delete(travelFeatured);
        return true;
    }
}
