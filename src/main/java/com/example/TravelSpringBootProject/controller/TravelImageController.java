package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.ImageTravelDto;
import com.example.TravelSpringBootProject.entity.ImageTravel;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.IImageTravel;
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
@CrossOrigin
@RequestMapping("/api/v1/travelDetails/image")
public class TravelImageController {

    @Autowired
    private IImageTravel iimageTravel;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> save(@RequestBody @Valid ImageTravelDto imageTravelDto){
        try{
            ImageTravel imageTravelRequest =  modelMapper.map(imageTravelDto,ImageTravel.class);
            ImageTravel imageTravel =  iimageTravel.save(imageTravelRequest,imageTravelDto.getTravelId());
            ImageTravelDto travelImageResponse = modelMapper.map(imageTravel,ImageTravelDto.class);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelImageResponse, null));

        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping("/travelId/{id}")
    public ResponseEntity<?> findByTravelId(@PathVariable Long id){
        try{
            Set<ImageTravelDto> imageTravelResponse = new HashSet<>();

            iimageTravel.findByTravelId(id).stream().forEach(item->{
                ImageTravelDto travelImageResponse = modelMapper.map(item,ImageTravelDto.class);
                imageTravelResponse.add(travelImageResponse);
            });

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,imageTravelResponse, null));

        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try{
            Set<ImageTravelDto> imageTravelResponse = new HashSet<>();

            iimageTravel.findAll().stream().forEach(item->{
                ImageTravelDto travelImageResponse = modelMapper.map(item,ImageTravelDto.class);
                imageTravelResponse.add(travelImageResponse);
            });

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,imageTravelResponse, null));

        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
           Boolean isDelete = iimageTravel.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isDelete, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }



}
