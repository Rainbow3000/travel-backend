package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.*;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ITravelDetailsService {
    Set<TravelFeatured> getAllFeaturedByTravelDetailsId(Long id);
    Set<TravelSchedule> getAllScheduleByTravelDetailsId(Long id);
    Set<TravelPriceTable> getAllPriceTableByTravelDetailsId(Long id);
    Set<Comment> getAllCommentByTravelDetailsId(Long id);
}
