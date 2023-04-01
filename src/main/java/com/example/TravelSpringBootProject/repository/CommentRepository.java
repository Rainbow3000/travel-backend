package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
