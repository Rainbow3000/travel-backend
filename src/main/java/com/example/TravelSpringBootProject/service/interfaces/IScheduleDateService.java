package com.example.TravelSpringBootProject.service.interfaces;


import com.example.TravelSpringBootProject.entity.ScheduleDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScheduleDateService {
    ScheduleDate save(ScheduleDate scheduleDate, Long travelScheduleId);

    List<ScheduleDate> findAll();
    Boolean update(ScheduleDate scheduleDate , Long scheduleDateId);
    Boolean delete ( Long scheduleDateId);
}
