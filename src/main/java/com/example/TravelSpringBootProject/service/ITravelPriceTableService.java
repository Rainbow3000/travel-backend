package com.example.TravelSpringBootProject.service;


import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import org.springframework.stereotype.Service;

@Service
public interface ITravelPriceTableService {
    TravelPriceTable save(TravelPriceTable travelPriceTable,Long travelDetailsId);
}
