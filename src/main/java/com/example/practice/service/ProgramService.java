package com.example.practice.service;

import com.example.practice.model.Program;
import com.example.practice.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public void save(Program program){
        programRepository.save(program);
    }

    public List<Program> getProgramsOfUniversity(Long universityid){
        return programRepository.findByUniversityid(universityid);
    }

    public Optional<Program> getById(Long programid){
        return programRepository.findById(programid);
    }

    public String deleteById(Long programid){
        return programRepository.deleteByProgramid(programid);
    }
    public boolean existsById(Long id){
       return programRepository.existsByProgramid(id);
    }

    public void updateById(Program program, Long id) {
        String code = program.getCode();
        String name = program.getName();
         programRepository.update(code, name, id);
    }

    public List<Program> getAll(){
        return programRepository.findAll();
    }
}
