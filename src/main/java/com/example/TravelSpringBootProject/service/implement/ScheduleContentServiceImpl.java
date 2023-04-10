package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.ScheduleContent;
import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.ScheduleContentRepository;
import com.example.TravelSpringBootProject.repository.ScheduleDateRepository;
import com.example.TravelSpringBootProject.service.interfaces.IScheduleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleContentServiceImpl implements IScheduleContentService {
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

    @Override
    public Boolean update(ScheduleContent scheduleContentRequest, Long scheduleContentId) {

        ScheduleContent scheduleContent = scheduleContentRepository.findById(scheduleContentId).orElseThrow(()-> new NotFoundException("Not found schedule content id"));
        scheduleContent.setContent(scheduleContentRequest.getContent());
        scheduleContentRepository.save(scheduleContent);
        return true;
    }

    @Override
    public Boolean delete(Long scheduleContentId) {
        ScheduleContent scheduleContent = scheduleContentRepository.findById(scheduleContentId).orElseThrow(()-> new NotFoundException("Not found schedule content id"));
        scheduleContentRepository.delete(scheduleContent);
        return true;
    }
}
