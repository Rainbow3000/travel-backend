package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.CommentDto;
import com.example.TravelSpringBootProject.dto.TravelFeaturedDto;
import com.example.TravelSpringBootProject.dto.TravelPriceTableDto;
import com.example.TravelSpringBootProject.entity.Comment;
import com.example.TravelSpringBootProject.entity.TravelFeatured;
import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.ITravelDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/travel/details")
@CrossOrigin
public class TravelDetailsController {
    @Autowired
    private ITravelDetailsService iTravelDetailsService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/{id}/featured")
    public ResponseEntity<?> getAllFeaturedByTravelDetails(@PathVariable Long id){
        try{
            Set<TravelFeatured> travelFeatured = iTravelDetailsService.getAllFeaturedByTravelDetailsId(id);
            List<TravelFeaturedDto> travelFeaturedResponse = new ArrayList<>();
            travelFeatured.stream().forEach(item->{
                TravelFeaturedDto travelFeaturedDto= modelMapper.map(item,TravelFeaturedDto.class);
                travelFeaturedResponse.add(travelFeaturedDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,travelFeaturedResponse,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }

    @GetMapping("/{id}/price/table")
    public ResponseEntity<?> getAllPriceTableByTravelDetails(@PathVariable Long id){
        try{
            Set<TravelPriceTable> travelPriceTables = iTravelDetailsService.getAllPriceTableByTravelDetailsId(id);
            List<TravelPriceTableDto> travelPriceTableResponse = new ArrayList<>();
            travelPriceTables.stream().forEach(item->{
                TravelPriceTableDto travelPriceTableDto = modelMapper.map(item,TravelPriceTableDto.class);
                travelPriceTableResponse.add(travelPriceTableDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,travelPriceTableResponse,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }

    @GetMapping("/{id}/comments")
    public  ResponseEntity<?> getAllCommentsByTravelDetails(@PathVariable Long id){
        try{
            Set<Comment> comments = iTravelDetailsService.getAllCommentByTravelDetailsId(id);
            List<CommentDto> commentResponse = new ArrayList<>();
            comments.stream().forEach(item->{
                CommentDto commentDto = modelMapper.map(item,CommentDto.class);
                commentResponse.add(commentDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,commentResponse,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }
}
