package com.example.TravelSpringBootProject.service.implement;

import com.example.TravelSpringBootProject.entity.Comment;
import com.example.TravelSpringBootProject.entity.Travel;
import com.example.TravelSpringBootProject.entity.User;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CommentRepository;
import com.example.TravelSpringBootProject.repository.TravelRepository;
import com.example.TravelSpringBootProject.repository.UserRepository;
import com.example.TravelSpringBootProject.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TravelRepository travelRepository;
    @Override
    public Comment save(Comment comment, Long userId, Long travelId) {

        User user =  userRepository.findById(userId).orElseThrow(()->new NotFoundException("Not found user id"));

        Travel travel = travelRepository.findById(travelId).orElseThrow(()->new NotFoundException("Not found travel id"));

        comment.setTravel(travel);
        comment.setUser(user);
        comment.setUserCommentName(user.getUsername().split("@")[0]);

        return commentRepository.save(comment);
    }

    @Override
    public Set<Comment> findByTravelId(Long travelId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()->new NotFoundException("Not found travel id"));
        return travel.getComments();
    }

    @Override
    public Boolean update(Comment commentRequest,Long commentId) {

        Comment comment = commentRepository.findById(commentId).orElse(null);
        if(comment == null){
            throw  new NotFoundException("commentId " + commentId + "not found !");
        }
        comment.setUserCommentName(commentRequest.getUserCommentName());
        comment.setContent(commentRequest.getContent());
        comment.setCommentDate(commentRequest.getCommentDate());
        commentRepository.save(comment);

        return true;
    }

    @Override
    public Boolean delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if(comment == null){
            throw new NotFoundException("commentId " + commentId + "not found !");
        }
        commentRepository.delete(comment);
        return true ;
    }

}
