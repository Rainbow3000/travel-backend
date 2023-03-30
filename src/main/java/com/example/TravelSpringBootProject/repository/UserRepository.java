package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    boolean existsUserByEmail(String email);
}
