package com.intellect.journalApp.controllers;


import com.intellect.journalApp.entity.JournalEntry;
import com.intellect.journalApp.entity.UserEntity;
import com.intellect.journalApp.repository.UserRepository;
import com.intellect.journalApp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUser(){
        return userService.getAll();

    }

    @PostMapping
    public void createUser(@RequestBody UserEntity user){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user,@PathVariable String userName){

        UserEntity userInDb=userService.findByUserName(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
