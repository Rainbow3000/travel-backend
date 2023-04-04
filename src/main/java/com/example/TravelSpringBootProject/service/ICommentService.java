package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ICommentService {
    Comment save(Comment comment,Long userId, Long travelId);
}
