package com.example.TravelSpringBootProject.service.interfaces;


import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ITravelScheduleService {
    TravelSchedule save(TravelSchedule travelSchedule,Long travelId);
    List<TravelSchedule> findAll();
    Set<TravelSchedule> findAllByTravelId(Long travelId);
    Boolean update (TravelSchedule travelSchedule, Long scheduleId);
    Boolean delete (Long scheduleId);
}
