package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.CommentDto;
import com.example.TravelSpringBootProject.entity.Comment;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.CommentRepository;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.ICommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/travel/comment")
public class CommentController {

    @Autowired
    private ICommentService iCommentService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CommentDto commentDto){
            try{
                Comment commentRequest = modelMapper.map(commentDto,Comment.class);
                Comment comment = iCommentService.save(commentRequest,commentDto.getUserId(),commentDto.getTravelId());
                CommentDto commentResponse = modelMapper.map(comment,CommentDto.class);
                return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success,commentResponse, null));
            }catch (NotFoundException ex){
                return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null, ex.getMessage()));

            }
    }
}
