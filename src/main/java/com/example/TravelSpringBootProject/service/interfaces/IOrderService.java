package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.Order;
import com.example.TravelSpringBootProject.entity.OrderDetails;
import org.springframework.stereotype.Service;


@Service
public interface IOrderService {
    public void save(Order order, OrderDetails orderDetails, Long userId,Long travelId);
}
