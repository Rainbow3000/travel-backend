package com.example.TravelSpringBootProject.controller;

import com.example.TravelSpringBootProject.dto.TestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public void createProduct(@RequestBody TestDto testDto){
        System.out.println(testDto.getProductId().toString());
    }
}
