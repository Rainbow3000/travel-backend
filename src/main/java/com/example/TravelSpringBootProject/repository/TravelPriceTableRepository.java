package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.TravelPriceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TravelPriceTableRepository extends JpaRepository<TravelPriceTable,Long> {
}
