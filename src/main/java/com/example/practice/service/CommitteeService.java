package com.example.practice.service;


import com.example.practice.model.Committee;
import com.example.practice.model.User;
import com.example.practice.model.enums.Role;
import com.example.practice.model.enums.Status_request;
import com.example.practice.repository.AppUserRepository;
import com.example.practice.repository.CommitteeRepository;
import com.example.practice.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommitteeService {
    @Autowired
    private CommitteeRepository repo;

    @Autowired
    private RequestRepository rRepo;

    @Autowired
    private AppUserRepository userRepo;

    public void save(Long requestid, Long userid, String email){
        Committee committee = new Committee();
        committee.setUserid(userid);
        committee.setRequestid(requestid);
        repo.save(committee);
        userRepo.updateRole(email, Role.COMMITTEE);
        rRepo.updateStatus(Status_request.VOTING, requestid);
    }

    public List<Committee> getByUserId(Long id){
       return repo.findAllByUserid(id);
    }

    public List<Committee> getByRequestId(Long id){
        return repo.findAllByRequestid(id);
    }
}
