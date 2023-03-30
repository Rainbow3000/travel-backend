package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TravelRepository extends JpaRepository<Travel,Long> {
}
