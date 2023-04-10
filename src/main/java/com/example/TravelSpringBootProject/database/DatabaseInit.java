package com.example.TravelSpringBootProject.database;

import com.example.TravelSpringBootProject.repository.RoleRepository;
import com.example.TravelSpringBootProject.service.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseInit implements CommandLineRunner {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {

    }
}
