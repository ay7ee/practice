package com.example.practice.controller;


import com.example.practice.model.ComissionRequest;
import com.example.practice.model.Status_comission_request;
import com.example.practice.service.ComissionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comissionRequest")
public class ComissionRequestController {
    @Autowired
    private ComissionRequestService service;

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


}
