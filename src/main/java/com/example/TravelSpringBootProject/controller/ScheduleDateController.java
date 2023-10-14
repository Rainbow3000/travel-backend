package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.ScheduleDateDto;
import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.IScheduleDateService;
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
@RequestMapping("/api/v1/travel/schedule/date")
@CrossOrigin
public class ScheduleDateController {

    @Autowired
    private IScheduleDateService iScheduleDateService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
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

    @GetMapping
    public ResponseEntity<?> findAll(){
        try{
            List<ScheduleDateDto> scheduleDateResponse = new ArrayList<>();
            iScheduleDateService.findAll().forEach(item->{
                ScheduleDateDto scheduleDateDto = modelMapper.map(item, ScheduleDateDto.class);
                scheduleDateResponse.add(scheduleDateDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,scheduleDateResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Boolean isDelete = iScheduleDateService.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isDelete, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
}
