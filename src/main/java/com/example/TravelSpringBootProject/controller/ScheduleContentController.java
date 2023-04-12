package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.ScheduleContentDto;
import com.example.TravelSpringBootProject.entity.ScheduleContent;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.IScheduleContentService;
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
@RequestMapping("/api/v1/travel/schedule/content")
@CrossOrigin
public class ScheduleContentController{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IScheduleContentService scheduleContentService;

    @PostMapping
    @RolesAllowed("[ROLE_ADMIN]")
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

    @GetMapping
    public ResponseEntity<?> findAll(){
        try{

            List<ScheduleContentDto> scheduleContentResponse = new ArrayList<>();

           scheduleContentService.findAll().forEach(item->{
               ScheduleContentDto scheduleContentDto = modelMapper.map(item,ScheduleContentDto.class);
               scheduleContentResponse.add(scheduleContentDto);
           });

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,scheduleContentResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    @RolesAllowed("[ROLE_ADMIN]")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{

           Boolean isDelete = scheduleContentService.delete(id);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isDelete, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

}
