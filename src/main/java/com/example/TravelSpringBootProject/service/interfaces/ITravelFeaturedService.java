package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.TravelFeatured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ITravelFeaturedService {
    TravelFeatured save(TravelFeatured travelFeatured,Long travelId);
    Set<TravelFeatured> findByTravelId(Long travelId);
    Boolean update(TravelFeatured travelFeatured, Long featuredId);
    Boolean delete(Long featuredId);

    List<TravelFeatured> findAll();

}
