package com.example.practice.service;


import com.example.practice.model.Committee;
import com.example.practice.model.enums.Status_request;
import com.example.practice.repository.CommitteeRepository;
import com.example.practice.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeService {
    @Autowired
    private CommitteeRepository repo;

    @Autowired
    private RequestRepository rRepo;

    public void save(Long requestid, Long userid){
        Committee committee = new Committee();
        committee.setUserid(userid);
        committee.setRequestid(requestid);
        repo.save(committee);
        rRepo.updateStatus(Status_request.VOTING, requestid);
    }

    public List<Committee> getByUserId(Long id){
       return repo.findAllByUserid(id);
    }

    public List<Committee> getByRequestId(Long id){
        return repo.findAllByRequestid(id);
    }
}
