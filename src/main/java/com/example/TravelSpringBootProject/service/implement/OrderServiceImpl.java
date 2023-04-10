package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.Order;
import com.example.TravelSpringBootProject.entity.OrderDetails;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.User;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.*;
import com.example.TravelSpringBootProject.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Override
    public void save(Order order, OrderDetails orderDetails,  Long userId, Long travelId) {

        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new NotFoundException("User id "+ userId + "not found !");
        }

        Travel travel = travelRepository.findById(travelId).orElse(null);
        if(travel == null){
            throw  new NotFoundException("Travel id " + travelId + "not found !");
        }
        order.setUser(user);

        orderDetails.setOrder(orderRepository.save(order));
        orderDetails.setTravel(travel);
        orderDetailsRepository.save(orderDetails);
    }
}
