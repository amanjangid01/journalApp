package com.intellect.journalApp.controllers;

import com.intellect.journalApp.entity.UserEntity;
import com.intellect.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }



    @GetMapping
    public List<UserEntity> getAllUser(){
        return userService.getAll();

    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody UserEntity user){
        userService.saveNewUser(user);
    }
}
