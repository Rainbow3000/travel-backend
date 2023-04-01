package com.example.TravelSpringBootProject.controller;
import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelDto;
import com.example.TravelSpringBootProject.entity.Category;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.ICategoryService;
import com.example.TravelSpringBootProject.service.ITravelService;
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
@RequestMapping("/api/v1/travel")
public class TravelController {
    @Autowired
    private ITravelService iTravelService;

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<?>findAll(){
        List<TravelDto> resultResponse = new ArrayList<>();
        iTravelService.findAll().stream().forEach(item-> {
            TravelDto travelDto =  modelMapper.map(item, TravelDto.class);
            resultResponse.add(travelDto);
        });
        return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success, resultResponse,null));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid TravelDto travelDto){
            try{
                Travel travelRequest = modelMapper.map(travelDto,Travel.class);
                Travel travel = iTravelService.save(travelRequest,travelDto.getCategoryId());
                TravelDto travelResponse = modelMapper.map(travel,TravelDto.class);
                return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(),Message.success, travelResponse,null));
            }catch (NotFoundException ex){
                return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(),Message.failure, null, ex.getMessage()));
            }


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleTravel(@PathVariable(name = "id") String id){
        try{
            System.out.println(id);
            return null;
        }catch (NotFoundException ex){
            return null;
        }
    }

//    @GetMapping
//    public ResponseEntity<?> getAllTravelByCategory(){
//        try{
//            return null;
//        }catch (NotFoundException ex){
//            return null;
//        }
//    }


}
