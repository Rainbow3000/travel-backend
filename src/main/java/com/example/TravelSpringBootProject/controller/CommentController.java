package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.CommentDto;
import com.example.TravelSpringBootProject.entity.Comment;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.ICommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/travel/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private ICommentService iCommentService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @RolesAllowed("[ROLE_ADMIN,ROLE_USER]")
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

    @GetMapping
    public ResponseEntity<?> findAll(){
        try{
            List<CommentDto> commentResponse = new ArrayList<>();
             iCommentService.findAll().stream().forEach(item->{
                CommentDto commentDto = modelMapper.map(item,CommentDto.class);
                commentResponse.add(commentDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,commentResponse,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }
    @GetMapping("/travelId/{id}")
    public ResponseEntity<?> findByTravelId(@PathVariable Long id){
        try{
            Set<Comment> comments = iCommentService.findByTravelId(id);
            List<CommentDto> commentResponse = new ArrayList<>();
            comments.stream().forEach(item->{
                CommentDto commentDto = modelMapper.map(item,CommentDto.class);
                commentResponse.add(commentDto);
            });
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,commentResponse,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @RolesAllowed("[ROLE_ADMIN]")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody @Valid CommentDto commentDto){
        try{
            Comment commentRequest = modelMapper.map(commentDto,Comment.class);
            Boolean isUpdate = iCommentService.update(commentRequest,id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,isUpdate,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("[ROLE_ADMIN]")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Boolean isDelete = iCommentService.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,isDelete,null));
        }catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }
}
