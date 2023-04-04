package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.ScheduleContent;
import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.ScheduleContentRepository;
import com.example.TravelSpringBootProject.repository.ScheduleDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleContentServiceImpl implements IScheduleContentService{
    @Autowired
    private ScheduleDateRepository scheduleDateRepository;

    @Autowired
    private ScheduleContentRepository scheduleContentRepository;
    @Override
    public ScheduleContent save(ScheduleContent scheduleContent, Long scheduleDateId) {

        ScheduleDate scheduleDate = scheduleDateRepository.findById(scheduleDateId).orElse(null);

        if(scheduleDate == null){
            throw new NotFoundException("travel schedule date id: "+ scheduleDateId + " not found");
        }
        scheduleContent.setScheduleDate(scheduleDate);
        return scheduleContentRepository.save(scheduleContent);
    }
}
