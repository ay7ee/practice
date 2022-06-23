package com.example.practice.service;

import com.example.practice.model.Decision;
import com.example.practice.model.enums.Status_request;
import com.example.practice.repository.CommitteeRepository;
import com.example.practice.repository.DecisionRepository;
import com.example.practice.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecisionService {
    @Autowired
    private DecisionRepository repo;

    @Autowired
    private CommitteeRepository cRepo;

    @Autowired
    private RequestRepository rRepo;

    public void create(Decision decision){
        repo.save(decision);
    }

    public List<Decision> getAll(){
        return repo.findAll();
    }

    public boolean checkIfFinished(Long id){
        Long numberAnswered = repo.checkIfFinished(id);
        Long numberOfComittee = cRepo.countCommitteeByRequestid(id);

        if (numberAnswered.equals(numberOfComittee)){

            rRepo.updateStatus(Status_request.FINISHED, id);
            return true;
        }
        return false;
    }
}
