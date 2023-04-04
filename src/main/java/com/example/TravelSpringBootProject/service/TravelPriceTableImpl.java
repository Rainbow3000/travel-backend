package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.TravelDetails;
import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelPriceTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelPriceTableImpl implements  ITravelPriceTableService{
    @Autowired
    private TravelPriceTableRepository travelPriceTableRepository;
    @Autowired
    private TravelDetailsRepository travelDetailsRepository;

    @Override
    public TravelPriceTable save(TravelPriceTable travelPriceTable,Long travelDetailsId) {

        TravelDetails travelDetails = travelDetailsRepository.findById(travelDetailsId).orElse(null);
        if(travelDetails == null){
            throw new NotFoundException("travel details id: "+ travelDetailsId + " not found");
        }
        travelPriceTable.setTravelDetails(travelDetails);

        return travelPriceTableRepository.save(travelPriceTable);
    }
}
