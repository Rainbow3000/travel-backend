package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelPriceTableRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.service.interfaces.ITravelPriceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TravelPriceTableServiceImpl implements ITravelPriceTableService {
    @Autowired
    private TravelPriceTableRepository travelPriceTableRepository;
    @Autowired
    private TravelRepository travelRepository;

    @Override
    public TravelPriceTable save(TravelPriceTable travelPriceTable,Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        travelPriceTable.setTravel(travel);
        return travelPriceTableRepository.save(travelPriceTable);
    }

    @Override
    public Set<TravelPriceTable> findByTravelId(Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        return travel.getTravelPriceTables();
    }

    @Override
    public Boolean update(TravelPriceTable travelPriceTableRequest, Long travelPriceTableId) {
        TravelPriceTable travelPriceTable = travelPriceTableRepository.findById(travelPriceTableId).orElseThrow(()-> new NotFoundException("Not found travel price id"));
        travelPriceTable.setPrice(travelPriceTableRequest.getPrice());
        travelPriceTable.setPlace(travelPriceTableRequest.getPlace());
        travelPriceTable.setTypeTransport(travelPriceTableRequest.getTypeTransport());
        travelPriceTableRepository.save(travelPriceTable);
        return true;
    }

    @Override
    public Boolean delete(Long travelPriceTableId) {
        TravelPriceTable travelPriceTable = travelPriceTableRepository.findById(travelPriceTableId).orElseThrow(()->new NotFoundException("Not found travel price id"));
        travelPriceTableRepository.delete(travelPriceTable);
        return true;
    }
}
