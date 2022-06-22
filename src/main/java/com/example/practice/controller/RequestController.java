package com.example.practice.controller;


import com.example.practice.model.Request;
import com.example.practice.model.enums.Status_request;
import com.example.practice.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;


    //Create request
    @PostMapping("/create")
    public String createRequest(@RequestBody Request request) {
        try {
            requestService.createRequest(request);
            return "Created";
        }catch (Exception e){
            return "Not created";
        }

    }

    //Read requests
    @GetMapping("/getRequests")
    public Collection<Request> getRequests() {
        return this.requestService.getAllRequests();
    }

//    Get request by ID
    @GetMapping("/{id}")
    public Optional<Request> getRequest(@PathVariable(value = "id") Long requestid){
        return this.requestService.getRequestById(requestid);
    }

    @PostMapping("/update")
    public String updateRequest( @RequestParam Status_request status_request, @RequestParam Long requestid ){
        try {
            requestService.updateRequest(status_request , requestid);
            return "Updated";
        }catch (Exception  e){
            return "Not updated";
        }

    }

    @GetMapping("/user/{id}")
    public Optional<Request> getRequestByUserId(@PathVariable(value = "id") Long id){
        return this.requestService.getRequestByMyId(id);
    }

}