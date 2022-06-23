package com.example.practice.controller;


import com.example.practice.model.ComissionRequest;
import com.example.practice.model.User;
import com.example.practice.model.enums.Status_comission_request;
import com.example.practice.service.ComissionRequestService;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/comissionRequest")
public class ComissionRequestController {
    @Autowired
    private ComissionRequestService service;
    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public String create(@RequestParam Long requestid){
        try {
             service.save(requestid);
             return "Created";
        }
        catch (Exception e){
            return "Not created";
        }
    }

    @PostMapping("/update")
    public String updateStatus(@RequestParam Status_comission_request status, @RequestParam Long id){
        try{
            service.update(status, id);
            return "Updated";
        }
        catch (Exception e){
            return "Not updated";
        }
    }

//    @PostMapping("committee/create")
//    public String createCommitee(@RequestParam Long crId, @RequestParam String email){
//        try {
//            User committee = (User) userService.findAllByEmail(email);
//            Long committeeid = committee.getUserid();
//            Optional<ComissionRequest> cr = service.findOne(crId);
//
//            cr.ifPresent(comissionRequest -> comissionRequest.setUsers((List<User>) committee));
//            return "Created";
//        }catch (Exception e){
//            return e.getMessage();
//        }
//
//    }


}
