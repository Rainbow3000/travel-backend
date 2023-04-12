package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.ScheduleDate;
import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.ScheduleDateRepository;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import com.example.TravelSpringBootProject.service.interfaces.IScheduleDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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

    @Override
    public List<ScheduleDate> findAll() {
        return scheduleDateRepository.findAll();
    }

    @Override
    public Boolean update(ScheduleDate scheduleDateRequest, Long scheduleDateId) {

        ScheduleDate scheduleDate = scheduleDateRepository.findById(scheduleDateId).orElseThrow(()-> new NotFoundException("Not found schedule id"));
        scheduleDate.setSessionDateName(scheduleDateRequest.getSessionDateName());
        scheduleDateRepository.save(scheduleDate);
        return true;
    }

    @Override
    public Boolean delete(Long scheduleDateId) {
        ScheduleDate scheduleDate = scheduleDateRepository.findById(scheduleDateId).orElseThrow(()-> new NotFoundException("Not found schedule id"));
        scheduleDateRepository.delete(scheduleDate);
        return true ;
    }
}
