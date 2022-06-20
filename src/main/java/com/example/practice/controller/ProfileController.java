package com.example.practice.controller;


import com.example.practice.model.Profile;
import com.example.practice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/create")
    public String create(@RequestBody Profile profile){
        try {
            profileService.saveProfile(profile);
            return "Created";
        }
        catch (Exception e){
            return "Not created";
        }

    }

    @GetMapping("{id}")
    public Optional<Profile> getOneUser(@PathVariable(value = "id") Long id){
        return profileService.getById(id);
    }
}
