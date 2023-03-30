package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.dto.TravelDto;
import com.example.TravelSpringBootProject.entity.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITravelService {
    Travel save(Travel travel, Long categoryId);
    List<Travel> findAll();
}
