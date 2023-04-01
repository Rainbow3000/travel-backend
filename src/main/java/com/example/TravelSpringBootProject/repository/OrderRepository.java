package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
