package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.Travel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ITravelService {
    Travel save(Travel travel,Long categoryId);
    List<Travel> findAll();
    Set<Travel> findAllByCategoryId(Long categoryId);
    Boolean update(Travel travel, Long travelId);
    Boolean delete(Long travelId);
}
