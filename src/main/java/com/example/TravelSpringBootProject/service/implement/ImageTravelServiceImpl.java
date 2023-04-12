package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.ImageTravel;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.ImageTravelRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.service.interfaces.IImageTravel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@Component
public class ImageTravelServiceImpl implements IImageTravel {

    @Autowired
    private ImageTravelRepository imageTravelRepository;

    @Autowired
    private  TravelRepository travelRepository;
    @Override
    public ImageTravel save(ImageTravel imageTravelRequest, Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        imageTravelRequest.setTravel(travel);
        return imageTravelRepository.save(imageTravelRequest);
    }

    @Override
    public Set<ImageTravel> findByTravelId(Long travelId) {

        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException(("Not found travel id")));
        return travel.getImageTravels();
    }

    @Override
    public List<ImageTravel> findAll() {
        return imageTravelRepository.findAll();
    }

    @Override
    public Boolean delete(Long imageTravelId) {
        ImageTravel imageTravel = imageTravelRepository.findById(imageTravelId).orElseThrow(()->new NotFoundException("Not found image travel id"));
        imageTravelRepository.delete(imageTravel);
        return true;
    }
}
