package com.example.anepformation.controllers;

import com.example.anepformation.model.User;
import com.example.anepformation.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user")
    public String getUser(){
        return "user";
    }
    @PostMapping(path = "/auth/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
