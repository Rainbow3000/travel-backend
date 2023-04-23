package com.example.TravelSpringBootProject.controller;
import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelDto;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.ICategoryService;
import com.example.TravelSpringBootProject.service.interfaces.ITravelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/travel")
@CrossOrigin
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
    @RolesAllowed("ROLE_ADMIN")
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


    @GetMapping("/getAllTravelByCategoryId/{id}")
    public ResponseEntity<?> getAllTravelByCategoryId (@PathVariable Long id){
        try{
            Set<Travel> travelResponse = iTravelService.findAllByCategoryId(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(),Message.success,travelResponse,null));

        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(),Message.failure, null, ex.getMessage()));

        }
    }

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> update (@PathVariable Long id,TravelDto travelDto){
        try{
            Travel travelRequest = modelMapper.map(travelDto,Travel.class);
            Boolean isUpdate = iTravelService.update(travelRequest,id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(),Message.success,isUpdate,null));
        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(),Message.failure, null, ex.getMessage()));

        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Boolean isDelete = iTravelService.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(),Message.success,isDelete,null));

        }catch(NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(),Message.failure, null, ex.getMessage()));
        }
    }
}
