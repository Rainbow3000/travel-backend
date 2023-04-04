package com.example.TravelSpringBootProject.service;


import com.example.TravelSpringBootProject.entity.ScheduleDate;
import org.springframework.stereotype.Service;

@Service
public interface IScheduleDateService {
    ScheduleDate save(ScheduleDate scheduleDate, Long travelScheduleId);
}
