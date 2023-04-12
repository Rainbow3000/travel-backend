package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.ImageTravel;
import com.example.TravelSpringBootProject.repository.ImageTravelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface IImageTravel {
    ImageTravel save(ImageTravel imageTravel ,Long travelId);
    Set<ImageTravel> findByTravelId (Long travelId);
    List<ImageTravel> findAll();
    Boolean delete(Long imageTravelId);
}
