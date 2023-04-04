package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.ScheduleDateDto;
import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.IScheduleDateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/travel/schedule/date")
public class ScheduleDateController {

    @Autowired
    private IScheduleDateService iScheduleDateService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ScheduleDateDto scheduleDateDto){
        try{
            ScheduleDate scheduleDateRequest = modelMapper.map(scheduleDateDto, ScheduleDate.class);
            ScheduleDate scheduleDate = iScheduleDateService.save(scheduleDateRequest, scheduleDateDto.getTravelScheduleId());
            ScheduleDateDto scheduleContentDateResponse = modelMapper.map(scheduleDate, ScheduleDateDto.class);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,scheduleContentDateResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));

        }
    }
}
