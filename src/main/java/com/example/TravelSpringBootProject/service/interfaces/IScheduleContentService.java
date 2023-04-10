package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.ScheduleContent;
import org.springframework.stereotype.Service;

@Service
public interface IScheduleContentService {
    ScheduleContent save(ScheduleContent scheduleContent, Long scheduleDateId);
    Boolean update (ScheduleContent scheduleContent , Long scheduleContentId);
    Boolean delete (Long scheduleContentId);
}
