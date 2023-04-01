package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.TravelDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelDetailsRepository extends JpaRepository<TravelDetails,Long> {
}
