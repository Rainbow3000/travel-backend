package com.example.TravelSpringBootProject.service.interfaces;

import com.example.TravelSpringBootProject.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface ICommentService {
    Comment save(Comment comment,Long userId, Long travelId);

    List<Comment> findAll();
    Set<Comment> findByTravelId(Long travelId);
    Boolean update(Comment comment,Long commentId);
    Boolean delete(Long commentId);

}
