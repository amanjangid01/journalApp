package com.intellect.journalApp.controllers;


import com.intellect.journalApp.entity.JournalEntry;
import com.intellect.journalApp.entity.UserEntity;
import com.intellect.journalApp.repository.UserRepository;
import com.intellect.journalApp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntity userInDb=userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUser(@RequestBody UserEntity user){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        userRepository.deleteByUserName(authentication.getName());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
