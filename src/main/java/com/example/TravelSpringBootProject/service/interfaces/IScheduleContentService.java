package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.ScheduleContent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScheduleContentService {
    ScheduleContent save(ScheduleContent scheduleContent, Long scheduleDateId);
    List<ScheduleContent> findAll();
    Boolean update (ScheduleContent scheduleContent , Long scheduleContentId);
    Boolean delete (Long scheduleContentId);
}
