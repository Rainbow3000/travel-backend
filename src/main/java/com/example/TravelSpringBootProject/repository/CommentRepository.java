package com.example.TravelSpringBootProject.repository;

import com.example.TravelSpringBootProject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
