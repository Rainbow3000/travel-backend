package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.Order;
import com.example.TravelSpringBootProject.entity.OrderDetails;
import com.example.TravelSpringBootProject.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface IOrderService {
    public void save(Order order, OrderDetails orderDetails, Long userId,Long travelId);
    List<OrderDetails> findAll();

    List<OrderDetails> findAllByUserId(Long userId);
    Boolean update (Long orderId);

    Boolean delete (Long orderId);

}
