package com.example.practice.controller;


import com.example.practice.model.Decision;
import com.example.practice.model.Subject;
import com.example.practice.service.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/decision")
public class DecisionController {

    @Autowired
    private DecisionService service;

    @PostMapping("/create")
    public String create(@RequestBody Decision decision){
        try{
            service.create(decision);
            return "Created";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/result/{id}")
    public List<Subject> getResult(@PathVariable Long id){
        return service.getResultOfVoting(id);
    }



}
