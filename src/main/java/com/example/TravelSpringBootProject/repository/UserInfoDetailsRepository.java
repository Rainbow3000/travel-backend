package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.UserInfoDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDetailsRepository extends JpaRepository<UserInfoDetails,Long> {

}
