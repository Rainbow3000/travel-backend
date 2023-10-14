package com.example.TravelSpringBootProject.controller;

import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.TravelPriceTableDto;
import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelPriceTableRepository;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.ITravelPriceTableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.persistence.TableGenerator;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/travel/price")
@CrossOrigin
public class TravelPriceTableController {
    @Autowired
    private ITravelPriceTableService iTravelPriceTableService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TravelPriceTableRepository travelPriceTableRepository;

    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> save(@RequestBody @Valid TravelPriceTableDto travelPriceTableDto){
        try{
            TravelPriceTable travelPriceTableRequest = modelMapper.map(travelPriceTableDto, TravelPriceTable.class);

            TravelPriceTable travelPriceTable = iTravelPriceTableService.save(travelPriceTableRequest,travelPriceTableDto.getTravelId());
            TravelPriceTableDto travelPriceTableResponse = modelMapper.map(travelPriceTable, TravelPriceTableDto.class);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelPriceTableResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }

    @GetMapping("/travelId/{id}")
    public ResponseEntity<?> findByTravelId(@PathVariable Long id){

        try{
            Set<TravelPriceTableDto> travelPriceTableResponse = new HashSet<>();

           iTravelPriceTableService.findByTravelId(id).forEach(item->{
               TravelPriceTableDto travelPriceTableDto = modelMapper.map(item, TravelPriceTableDto.class);
               travelPriceTableResponse.add(travelPriceTableDto);
           });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelPriceTableResponse, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,travelPriceTableRepository.findAll(), null));
    }


    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Boolean isDelete = iTravelPriceTableService.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,isDelete, null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));
        }
    }


}
