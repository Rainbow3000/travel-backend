package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IRoleService {
    Role save(Role role);
}
