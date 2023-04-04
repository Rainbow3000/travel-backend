package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.TravelFeatured;
import org.springframework.stereotype.Service;

@Service
public interface ITravelFeaturedService {
    TravelFeatured save(TravelFeatured travelFeatured,String travelDetailsId);
}
