package com.example.practice.controller;


import com.example.practice.model.Role;
import com.example.practice.model.University;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public Long getUserId(){
        return userService.getUserId();
    }

    @GetMapping("/id/{id}")
    public Optional<User> getUserData(@PathVariable(value = "id") Long userid){
        return this.userService.getUserById(userid);
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
