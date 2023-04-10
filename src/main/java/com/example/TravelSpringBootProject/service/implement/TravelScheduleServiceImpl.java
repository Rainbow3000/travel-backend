package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.TravelSchedule;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.repository.TravelScheduleRepository;
import com.example.TravelSpringBootProject.service.interfaces.ITravelScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@Component
public class TravelScheduleServiceImpl implements ITravelScheduleService {
    @Autowired
    private TravelScheduleRepository travelScheduleRepository;

    @Autowired
    private TravelRepository travelRepository;
    @Override
    public TravelSchedule save(TravelSchedule travelSchedule, Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        travelSchedule.setTravel(travel);
        return travelScheduleRepository.save(travelSchedule);
    }

    @Override
    public List<TravelSchedule> findAll() {
        return travelScheduleRepository.findAll();
    }

    @Override
    public Set<TravelSchedule> findAllByTravelId(Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()-> new NotFoundException("Not found travel id"));
        return travel.getTravelSchedules();
    }

    @Override
    public Boolean update(TravelSchedule travelScheduleRequest, Long scheduleId) {

        TravelSchedule travelSchedule = travelScheduleRepository.findById(scheduleId).orElseThrow(()-> new NotFoundException("Not found travel schedule id"));
        travelSchedule.setDateName(travelScheduleRequest.getDateName());
        return true;
    }

    @Override
    public Boolean delete(Long scheduleId) {
        TravelSchedule travelSchedule = travelScheduleRepository.findById(scheduleId).orElseThrow(()-> new NotFoundException("Not found travel schedule id"));
        travelScheduleRepository.delete(travelSchedule);
        return true;
    }
}
