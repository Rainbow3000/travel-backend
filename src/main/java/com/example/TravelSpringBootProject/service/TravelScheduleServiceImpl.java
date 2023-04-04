package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.TravelDetails;
import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TravelScheduleServiceImpl implements ITravelScheduleService{

    @Autowired
    private TravelDetailsRepository travelDetailsRepository;
    @Autowired
    private TravelScheduleRepository travelScheduleRepository;
    @Override
    public TravelSchedule save(TravelSchedule travelSchedule, Long travelDetailsId) {
        TravelDetails travelDetails = travelDetailsRepository.findById(Long.valueOf(travelDetailsId)).orElse(null);
        if(travelDetails == null){
            throw new NotFoundException("travel details id: "+ travelDetailsId + " not found");
        }

        travelSchedule.setTravelDetails(travelDetails);
        return travelScheduleRepository.save(travelSchedule);
    }

    @Override
    public List<TravelSchedule> findAll() {
        return travelScheduleRepository.findAll();
    }
}
