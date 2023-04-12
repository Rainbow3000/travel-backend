package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelFeaturedDto;
import com.example.TravelSpringBootProject.entity.TravelFeatured;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.ITravelFeaturedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/travel/featured")
@CrossOrigin
public class TravelFeaturedController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITravelFeaturedService iTravelFeaturedService;


    @PostMapping
    @RolesAllowed("[ROLE_ADMIN]")
    public ResponseEntity<?> createFeatured(@RequestBody @Valid TravelFeaturedDto travelFeaturedDto){
        try{
            TravelFeatured travelFeaturedRequest = modelMapper.map(travelFeaturedDto,TravelFeatured.class);
            TravelFeatured travelFeatured =  iTravelFeaturedService.save(travelFeaturedRequest,travelFeaturedDto.getTravelId());
            TravelFeaturedDto travelFeaturedResponse = modelMapper.map(travelFeatured,TravelFeaturedDto.class);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelFeaturedResponse, null));
        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping("/travelId/{id}")
    public ResponseEntity<?> findAllByTravelId(@PathVariable Long id){
        try{

            Set<TravelFeaturedDto> travelFeaturedResponse = new HashSet<>();
            iTravelFeaturedService.findByTravelId(id).forEach(item->{
                TravelFeaturedDto travelFeaturedDto = modelMapper.map(item,TravelFeaturedDto.class);
                travelFeaturedResponse.add(travelFeaturedDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelFeaturedResponse, null));
        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try{

            Set<TravelFeaturedDto> travelFeaturedResponse = new HashSet<>();
            iTravelFeaturedService.findAll().forEach(item->{
                TravelFeaturedDto travelFeaturedDto = modelMapper.map(item,TravelFeaturedDto.class);
                travelFeaturedResponse.add(travelFeaturedDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelFeaturedResponse, null));
        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("[ROLE_ADMIN]")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{


            Boolean isDelete = iTravelFeaturedService.delete(id);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isDelete, null));
        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
}
