package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User save(User user);
    User findByEmail(String email);
    boolean existsUserByEmail(String email);
}
