package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    User save(User user);
    User findByEmail(String email);
    boolean existsUserByEmail(String email);
    Boolean updateByAdmin (User user,Long userId);

    Boolean updateByUser (User user, Long userId);
    Boolean delete (Long userId);

    List<User> findAll();
}
