package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.ScheduleDateRepository;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ScheduleDateServiceImpl implements IScheduleDateService {

    @Autowired
    private ScheduleDateRepository scheduleDateRepository;

    @Autowired
    private TravelScheduleRepository travelScheduleRepository;
    @Override
    public ScheduleDate save(ScheduleDate scheduleDate, Long travelScheduleId) {
        TravelSchedule travelSchedule = travelScheduleRepository.findById(Long.valueOf(travelScheduleId)).orElse(null);
        if(travelSchedule == null){
            throw new NotFoundException("travel schedule id: "+ travelScheduleId + " not found");
        }
        scheduleDate.setTravelSchedule(travelSchedule);

        return scheduleDateRepository.save(scheduleDate);
    }
}
