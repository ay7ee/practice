package com.example.practice.service;


import com.example.practice.model.ComissionRequest;
import com.example.practice.model.Status_comission_request;
import com.example.practice.repository.ComissionRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComissionRequestService {

    @Autowired
    private ComissionRequestRepo comissionRequestRepo;

    public void save(Long id){
        ComissionRequest comissionRequest = new ComissionRequest();
        comissionRequest.setStatus_comission_request(Status_comission_request.PENDING);
        comissionRequest.setRequestid(id);
        comissionRequestRepo.save(comissionRequest);
    }

    public void update(Status_comission_request status, Long id){
      comissionRequestRepo.updateStatus(status, id);
    }
}
