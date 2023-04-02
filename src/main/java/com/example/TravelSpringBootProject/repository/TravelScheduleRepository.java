package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.TravelSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelScheduleRepository extends JpaRepository<TravelSchedule,Long> {
}
