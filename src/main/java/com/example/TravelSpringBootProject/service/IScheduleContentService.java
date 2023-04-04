package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.ScheduleContent;
import org.springframework.stereotype.Service;

@Service
public interface IScheduleContentService {
    ScheduleContent save(ScheduleContent scheduleContent, Long scheduleDateId);
}
