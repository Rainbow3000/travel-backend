package com.example.TravelSpringBootProject.repository;


import com.example.TravelSpringBootProject.entity.ScheduleContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleContentRepository extends JpaRepository<ScheduleContent,Long> {
}
