package com.example.practice.controller;


import com.example.practice.model.Committee;
import com.example.practice.service.CommitteeService;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/committee")
public class CommiteeController {

    @Autowired
    private CommitteeService service;
    @Autowired
    private UserService userService;


    @GetMapping("/create")
    public String create(@RequestParam(name = "requestid") Long requestid, @RequestParam(name = "email") String email){
        try {
            Long userid = userService.findidByEmail(email);
            service.save(requestid, userid, email);
            return "Created";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("/user/{id}")
    public List<Committee> getlist(@PathVariable Long id){
        return service.getByUserId(id);
    }

    @GetMapping("/request/{id}")
    public List<Committee> getByReqId(@PathVariable Long id){
        return service.getByRequestId(id);
    }
}
