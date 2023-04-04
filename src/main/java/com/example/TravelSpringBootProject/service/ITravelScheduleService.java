package com.example.TravelSpringBootProject.service;


import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITravelScheduleService {
    TravelSchedule save(TravelSchedule travelSchedule , Long travelDetailsId);
    List<TravelSchedule> findAll();
}
