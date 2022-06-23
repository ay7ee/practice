package com.example.practice.service;


import com.example.practice.model.Committee;
import com.example.practice.repository.CommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeService {
    @Autowired
    private CommitteeRepository repo;

    public void save(Committee committee){
        repo.save(committee);
    }

    public List<Committee> getByUserId(Long id){
       return repo.findAllByUserid(id);
    }

    public List<Committee> getByRequestId(Long id){
        return repo.findAllByComissionRequestid(id);
    }
}
