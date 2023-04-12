package com.example.TravelSpringBootProject.controller;

import com.example.TravelSpringBootProject.constants.Message;
import com.example.TravelSpringBootProject.dto.UserDto;
import com.example.TravelSpringBootProject.entity.User;
import com.example.TravelSpringBootProject.exception.DuplicateException;
import com.example.TravelSpringBootProject.repository.UserRepository;
import com.example.TravelSpringBootProject.response.DataResponse;
import com.example.TravelSpringBootProject.security.JwtUtils;
import com.example.TravelSpringBootProject.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin

public class AuthController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto){
        try{
            User userRequest = modelMapper.map(userDto,User.class);
            User user = userService.save(userRequest);
            UserDto userResponse = modelMapper.map(user,UserDto.class);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.CREATED.value(), Message.success, userResponse,null));
        }catch (DuplicateException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Message.failure, null,ex.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDto userDto){

        try{
            User userRequest = modelMapper.map(userDto,User.class);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword())
            );
            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtils.generateAccessToken(user);
            UserDto userResponse = modelMapper.map(user,UserDto.class);
            userResponse.setAccessToken(accessToken);
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.OK.value(), Message.success,userResponse,null));
        }
        catch (BadCredentialsException ex){
            return ResponseEntity.ok().body(new DataResponse(HttpStatus.NOT_FOUND.value(), Message.failure,null,"Tài khoản hoặc mật khẩu không đúng"));
        }
    }


}
