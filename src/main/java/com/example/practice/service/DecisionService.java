package com.example.practice.service;

import com.example.practice.model.Decision;
import com.example.practice.model.Subject;
import com.example.practice.model.enums.Status_request;
import com.example.practice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DecisionService {
    @Autowired
    private DecisionRepository repo;

    @Autowired
    private RequestRepository reqRepo;

    @Autowired
    private SubjectRepository subRepo;

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

    public List<Subject> getResultOfVoting(Long requestid){
      if(checkIfFinished(requestid)){
          Long numberOfComittee = cRepo.countCommitteeByRequestid(requestid);
          Long programid = reqRepo.findById(requestid).get().getProgramid();
          List<Long> ids = subRepo.getIds(programid);

          ArrayList<Long> acceptedSubjects = new ArrayList<Long>();
          for(Long d : ids){
              Long result = repo.getResult(d, requestid);
              if (result > numberOfComittee/2){
                  acceptedSubjects.add(d);
              }
              else{
                  continue;
              }
          }
          return subRepo.findBySubjectids(acceptedSubjects);
      }
      else{
          return null;
      }

    }
}
