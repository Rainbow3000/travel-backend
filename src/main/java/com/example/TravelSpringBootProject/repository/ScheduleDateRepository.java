package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.ScheduleDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ScheduleDateRepository extends JpaRepository<ScheduleDate,Long> {
}
