package com.example.practice.service;

import com.example.practice.model.Request;
import com.example.practice.model.Status_request;
import com.example.practice.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request createRequest(Request request) {
        request.setStatus_request(Status_request.PENDING);
        return this.requestRepository.save(request);
    }
    public List<Request> getAllRequests() {
        return this.requestRepository.findAll();
    }

    public Optional<Request> getRequestById(Long requestid) {
        return this.requestRepository.findById(requestid);
    }

    public void updateRequest(Status_request status_request, Long id){
        requestRepository.updateStatus(status_request, id);
    }

    public Optional<Request> getRequestByMyId(Long id) {
        return requestRepository.findAllByUserid(id);
    }
}
