package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPriceTableRepository extends JpaRepository<TravelPriceTable,Long> {
}
