package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.ScheduleContentDto;
import com.example.TravelSpringBootProject.entity.ScheduleContent;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.IScheduleContentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.prefs.BackingStoreException;

@RestController
@RequestMapping("/api/v1/travel/schedule/content")
public class ScheduleContentController{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IScheduleContentService scheduleContentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ScheduleContentDto scheduleContentDto){
        try{
            ScheduleContent scheduleContentRequest = modelMapper.map(scheduleContentDto,ScheduleContent.class);
            ScheduleContent scheduleContent = scheduleContentService.save(scheduleContentRequest,scheduleContentDto.getScheduleDateId());
            ScheduleContentDto scheduleContentResponse = modelMapper.map(scheduleContent,ScheduleContentDto.class);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,scheduleContentResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

}
