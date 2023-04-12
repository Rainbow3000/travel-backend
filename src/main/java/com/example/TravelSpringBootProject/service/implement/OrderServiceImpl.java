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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
        orderDetails.setStatus("Chờ duyệt");
        orderDetailsRepository.save(orderDetails);
    }

    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public List<OrderDetails> findAllByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User not found !"));
        List<OrderDetails> orderDetailsResponse = new ArrayList<>();
        user.getOrders().forEach(item->{
            orderDetailsResponse.add(orderDetailsRepository.findById(item.getId()).orElse(null));
        });
        return orderDetailsResponse;
    }


    @Override
    public Boolean update(Long orderId) {
        OrderDetails order = orderDetailsRepository.findById(orderId).orElseThrow(()-> new NotFoundException("Not found"));
        order.setStatus("Đã duyệt");
        orderDetailsRepository.save(order);
        return true ;
    }

    @Override
    public Boolean delete(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new NotFoundException("Not found order id"));
        orderDetailsRepository.delete(order.getOrderDetails());
        orderRepository.delete(order);
        return true;
    }
}
