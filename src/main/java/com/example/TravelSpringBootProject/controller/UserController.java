package com.example.TravelSpringBootProject.controller;


import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.UserDto;
import com.example.TravelSpringBootProject.dto.UserDtoResponse;
import com.example.TravelSpringBootProject.entity.User;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> update(@RequestBody @Valid UserDto userDto, @PathVariable  Long id){
        try{

            User user = modelMapper.map(userDto,User.class);

            Boolean isUpdate = iUserService.updateByAdmin(user,id);

            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,isUpdate,null));
        }
        catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Boolean isDelete = iUserService.delete(id);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,isDelete,null));
        }
        catch (NotFoundException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,ex.getMessage()));
        }
    }

    @GetMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> findAll(){
        try{

            List<User> users = iUserService.findAll();
            List<UserDtoResponse> userDtoResponses = new ArrayList<>();

            users.forEach(item->{
                if(item.getId() != 1 && item.getStatus() != 2){
                    UserDtoResponse userDtoResponse = modelMapper.map(item,UserDtoResponse.class);
                    userDtoResponses.add(userDtoResponse);
                }
            });


            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,userDtoResponses,null));
        }
        catch (BadCredentialsException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,"Tài khoản hoặc mật khẩu không đúng"));
        }
    }
}
