package com.example.TravelSpringBootProject.service.interfaces;


import com.example.TravelSpringBootProject.entity.ScheduleDate;
import org.springframework.stereotype.Service;

@Service
public interface IScheduleDateService {
    ScheduleDate save(ScheduleDate scheduleDate, Long travelScheduleId);
    Boolean update(ScheduleDate scheduleDate , Long scheduleDateId);
    Boolean delete ( Long scheduleDateId);
}
