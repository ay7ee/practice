package com.example.practice.controller;


import com.example.practice.model.Subject;
import com.example.practice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/create")
    public String create(@RequestBody Subject subject){
        try {
            subjectService.save(subject);
            return "Created";
        }catch (Exception e){
            return "Not created";
        }
    }

    @GetMapping("/program/{id}")
    public List<Subject> getProgramsSubjects(@PathVariable Long id){
        return subjectService.getByProgramId(id);
    }

    @GetMapping("/{id}")
    public Optional<Subject> getById(@PathVariable Long id){
        return subjectService.getSubject(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable(name = "id") Long id){
                subjectService.deleteById(id);
        return ResponseEntity.ok().body("Subject has been removed");

    }

}
