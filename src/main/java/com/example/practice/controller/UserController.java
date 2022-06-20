package com.example.practice.controller;


import com.example.practice.model.Role;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public String getUser(){
        return userService.getUserData();
    }

    @PostMapping("/update")
    public String setNewRole(@RequestParam String email){
        try {
         userService.updateUser(email);
            return "User role updated";
        } catch (Exception e) {
            return "Not updated";

        }
    }

    @GetMapping("/{email}")
    public List<User> findUser(@PathVariable String email){
        return userService.findAllByEmail(email);
    }
}
