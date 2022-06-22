package com.example.practice.service;

import com.example.practice.model.University;
import com.example.practice.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public void saveUniversity(University university){
        universityRepository.save(university);
    }

    public List<University> getUniversities(){
        return universityRepository.getAll();
    }

    public Optional<University> getUniversistyById(Long universityid){
        return universityRepository.getUniversity(universityid);
    }

    public Optional<University> getUniversistyByName(String name) {
        return universityRepository.getUniversityByName(name);
    }
}
