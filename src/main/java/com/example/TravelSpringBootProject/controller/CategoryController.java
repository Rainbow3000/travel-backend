package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.CategoryDto;
import com.example.TravelSpringBootProject.entity.Category;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.ICategoryService;
import org.apache.coyote.Response;
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
@RequestMapping("/api/v1/category")
public class CategoryController {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<?> findAll(){
        List<CategoryDto> resultResponse = new ArrayList<>();
        iCategoryService.findAll().stream().forEach(item-> {
            CategoryDto categoryDto =  modelMapper.map(item, CategoryDto.class);
            resultResponse.add(categoryDto);
        });
       return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(),Message.success,resultResponse,null));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CategoryDto categoryDto){
       Category categoryRequest = modelMapper.map(categoryDto,Category.class);
       Category category = iCategoryService.save(categoryRequest);
       CategoryDto categoryResponse = modelMapper.map(category,CategoryDto.class);
       return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(),Message.success,categoryResponse,null));
    }
}
