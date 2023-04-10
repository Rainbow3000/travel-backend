package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.ImageTravel;
import com.example.TravelSpringBootProject.repository.ImageTravelRepository;

public interface IImageTravel {
    ImageTravel save(ImageTravel imageTravel ,Long travelId);
    Boolean delete(Long imageTravelId);
}
