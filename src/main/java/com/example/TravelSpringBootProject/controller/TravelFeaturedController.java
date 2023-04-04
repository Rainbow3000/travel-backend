package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelFeaturedDto;
import com.example.TravelSpringBootProject.entity.TravelFeatured;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.ITravelFeaturedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/featured")
public class TravelFeaturedController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITravelFeaturedService iTravelFeaturedService;


    @PostMapping
    public ResponseEntity<?> createFeatured(@RequestBody @Valid TravelFeaturedDto travelFeaturedDto){
        try{
            TravelFeatured travelFeaturedRequest = modelMapper.map(travelFeaturedDto,TravelFeatured.class);
            TravelFeatured travelFeatured =  iTravelFeaturedService.save(travelFeaturedRequest,travelFeaturedDto.getTravelDetailsId());
            TravelFeaturedDto travelFeaturedResponse = modelMapper.map(travelFeatured,TravelFeaturedDto.class);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelFeaturedResponse, null));
        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
}
