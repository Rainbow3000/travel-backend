package com.example.TravelSpringBootProject.service;

import com.example.TravelSpringBootProject.entity.Role;
import com.example.TravelSpringBootProject.exception.DuplicateException;
import com.example.TravelSpringBootProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        Role roleExists =  roleRepository.findByRoleName(role.getRoleName()).orElse(null);
        if(roleExists != null){
           throw  new  DuplicateException("Role already exists !");
        }
        return roleRepository.save(role) ;
    }

}
