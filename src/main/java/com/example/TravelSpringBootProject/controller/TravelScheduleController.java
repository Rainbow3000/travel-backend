package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelFeaturedDto;
import com.example.TravelSpringBootProject.dto.TravelScheduleDto;
import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.ITravelScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/travel/schedule")
@CrossOrigin
public class TravelScheduleController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITravelScheduleService iTravelScheduleService;
    @PostMapping
    @RolesAllowed("[ROLE_ADMIN]")
    public ResponseEntity<?> save(@RequestBody @Valid TravelScheduleDto travelScheduleDto){
        try{
            TravelSchedule travelScheduleRequest = modelMapper.map(travelScheduleDto,TravelSchedule.class);

            TravelSchedule travelSchedule = iTravelScheduleService.save(travelScheduleRequest,travelScheduleDto.getTravelId());

            TravelFeaturedDto travelScheduleResponse = modelMapper.map(travelSchedule,TravelFeaturedDto.class);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelScheduleResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping

    public ResponseEntity<?> getAll(){
        List<TravelScheduleDto> travelScheduleResponse = new ArrayList<>();

        iTravelScheduleService.findAll().stream().forEach(item->{
            TravelScheduleDto travelScheduleDto = modelMapper.map(item,TravelScheduleDto.class);
            travelScheduleDto.setScheduleDates(item.getScheduleDate());
            travelScheduleResponse.add(travelScheduleDto);
        });
        return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelScheduleResponse, null));

    }


    @GetMapping("/travelId/{id}")
    public ResponseEntity<?> findAllByTravelId(@PathVariable Long id){
        try {
            List<TravelScheduleDto> travelScheduleResponse = new ArrayList<>();
            iTravelScheduleService.findAllByTravelId(id).stream().forEach(item->{
                TravelScheduleDto travelScheduleDto = modelMapper.map(item,TravelScheduleDto.class);
                travelScheduleDto.setScheduleDates(item.getScheduleDate());
                travelScheduleResponse.add(travelScheduleDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelScheduleResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }


    }
}
