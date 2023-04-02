package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.TravelFeatured;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelFeaturedRepository extends JpaRepository<TravelFeatured,Long> {
}
