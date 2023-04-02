package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.dto.TravelDto;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.TravelDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITravelService {
    Travel save(Travel travel, TravelDetails travelDetails, Long categoryId);
    List<Travel> findAll();
}
