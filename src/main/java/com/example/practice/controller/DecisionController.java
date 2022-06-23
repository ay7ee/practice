package com.example.practice.controller;


import com.example.practice.service.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/decision")
public class DecisionController {

    @Autowired
    private DecisionService service;

    @GetMapping("/result/{id}")
    public Boolean getResult(@PathVariable Long id){
        return service.checkIfFinished(id);
    }
}
