package com.example.TravelSpringBootProject.controller;

import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelPriceTableDto;
import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.ITravelPriceTableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/travel/price")
@CrossOrigin
public class TravelPriceTableController {
    @Autowired
    private ITravelPriceTableService iTravelPriceTableService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid TravelPriceTableDto travelPriceTableDto){
        try{
            TravelPriceTable travelPriceTableRequest = modelMapper.map(travelPriceTableDto, TravelPriceTable.class);

            TravelPriceTable travelPriceTable = iTravelPriceTableService.save(travelPriceTableRequest,travelPriceTableDto.getTravelDetailsId());
            TravelPriceTableDto travelPriceTableResponse = modelMapper.map(travelPriceTable, TravelPriceTableDto.class);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelPriceTableResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
}
