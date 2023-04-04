package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.Comment;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.TravelDetails;
import com.example.TravelSpringBootProject.entity.User;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CommentRepository;
import com.example.TravelSpringBootProject.repository.TravelDetailsRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CommentServiceImpl implements ICommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TravelDetailsRepository travelDetailsRepository;
    @Override
    public Comment save(Comment comment, Long userId, Long travelId) {

        User user =  userRepository.findById(userId).orElse(null);

        TravelDetails travelDetails = travelDetailsRepository.findById(travelId).orElse(null);

        if(user == null){
            throw  new NotFoundException("User id " + userId + "not found !");
        }
        if(travelDetails == null){
            throw  new NotFoundException("travel id " + travelId + "not found !");
        }
        comment.setTravelDetails(travelDetails);
        comment.setUser(user);
        comment.setUserCommentName(user.getUsername().split("@")[0]);

        return commentRepository.save(comment);
    }

}
