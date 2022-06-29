package com.example.practice.controller;


import com.example.practice.model.University;
import com.example.practice.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/create")
    public String createuniversity(@RequestBody University university){
        try {
            universityService.saveUniversity(university);
            return "Universityy created";
        }
        catch (Exception e){
            return "Not created";
        }
    }

    @GetMapping("/getUniversities")
    public List<University> getUniversities(){
        return this.universityService.getUniversities();
    }

    @GetMapping("/{id}")
    public Optional<University> getUniversity(@PathVariable(value = "id") Long universityid){
        return this.universityService.getUniversistyById(universityid);
    }

    @GetMapping("/byName/{name}")
    public Optional<University> getUniversityByName(@PathVariable(value = "name") String name){
        return this.universityService.getUniversistyByName(name);
    }
}
