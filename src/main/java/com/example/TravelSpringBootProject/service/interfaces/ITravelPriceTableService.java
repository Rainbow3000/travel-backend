package com.example.TravelSpringBootProject.service.interfaces;


import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ITravelPriceTableService {
    TravelPriceTable save(TravelPriceTable travelPriceTable,Long travelId);
    Set<TravelPriceTable> findByTravelId(Long travelId);

    Boolean update(TravelPriceTable travelPriceTable, Long travelPriceTableId);
    Boolean delete(Long travelPriceTableId);
}
