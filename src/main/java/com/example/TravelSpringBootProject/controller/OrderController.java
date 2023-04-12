package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.OrderDto;
import com.example.TravelSpringBootProject.entity.Order;
import com.example.TravelSpringBootProject.entity.OrderDetails;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.OrderDetailsRepository;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.IOrderService;
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
@CrossOrigin
@RequestMapping("/api/v1/travel/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
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

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> update(@PathVariable Long id){
        try{
            Boolean isUpdate =  iOrderService.update(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isUpdate, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Boolean isDelete = iOrderService.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isDelete, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> findAll(){
        try{
            List<OrderDto> orderResponse = new ArrayList<>();

            iOrderService.findAll().forEach(item->{
                OrderDto orderDto = modelMapper.map(item,OrderDto.class);
                orderResponse.add(orderDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,orderResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping("/userId/{id}")
    @RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<?> findAllByUserId(@PathVariable Long id){
        try{
            List<OrderDto> orderResponse = new ArrayList<>();

            iOrderService.findAllByUserId(id).forEach(item->{
                OrderDto orderDto = modelMapper.map(item,OrderDto.class);
                orderResponse.add(orderDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,orderResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
}
