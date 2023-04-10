package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.OrderDto;
import com.example.TravelSpringBootProject.entity.Order;
import com.example.TravelSpringBootProject.entity.OrderDetails;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/travel/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid OrderDto orderDto){
        try{
            Order order = modelMapper.map(orderDto, Order.class);
            OrderDetails orderDetails = modelMapper.map(orderDto, OrderDetails.class);
            iOrderService.save(order,orderDetails,orderDto.getUserId(),orderDto.getTravelId());
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,"order success !", null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
}
