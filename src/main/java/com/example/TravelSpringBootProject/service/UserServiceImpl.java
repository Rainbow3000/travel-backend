package com.example.TravelSpringBootProject.service;


import com.example.TravelSpringBootProject.entity.Role;
import com.example.TravelSpringBootProject.entity.User;
import com.example.TravelSpringBootProject.exception.DuplicateException;
import com.example.TravelSpringBootProject.exception.NotFoundException;
import com.example.TravelSpringBootProject.repository.RoleRepository;
import com.example.TravelSpringBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User save(User user) {
        User userExist = userRepository.findByEmail(user.getEmail());
        if(userExist != null){
            throw new DuplicateException("user already exists");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(user.getPassword());
        Role roleUser = roleRepository.findByRoleName("ROLE_USER").orElse(null);
        if(roleUser == null){
            user.addRole(roleRepository.save(new Role("ROLE_USER")));
            user.setPassword(password);
            return  userRepository.save(user);
        }
        user.setPassword(password);
        user.addRole(roleUser);
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }


}
