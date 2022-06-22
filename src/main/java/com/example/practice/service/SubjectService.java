package com.example.practice.service;

import com.example.practice.model.Subject;
import com.example.practice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;
    public void save(Subject subject){
        subjectRepository.save(subject);
    }

    public Optional<Subject> getSubject(Long id){
        return subjectRepository.findBySubjectid(id);
    }

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public String deleteById(Long subjectid){
        return subjectRepository.deleteBySubjectid(subjectid);
    }
    public boolean existsById(Long id){
        return subjectRepository.existsBySubjectid(id);
    }

    public List<Subject> getByProgramId(Long id) {
       return subjectRepository.getByProgram(id);
    }
}
