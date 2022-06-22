package com.example.practice.controller;


import com.example.practice.model.Program;
import com.example.practice.model.Request;
import com.example.practice.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/program")
public class ProgramController {

    @Autowired
    ProgramService programService;

    @PostMapping("/create")
    public String create(@RequestBody Program program){
        try{
            programService.save(program);
            return "Created";
        }catch (Exception e) {
            return "Not created";
        }
    }
    @GetMapping("/{id}")
    public Optional<Program> getById(@PathVariable(value = "id") Long id){
        return this.programService.getById(id);
    }

    @GetMapping("/university/{id}")
    public List<Program> getByUniversityId(@PathVariable(value = "id") Long id){
        return this.programService.getProgramsOfUniversity(id);
    }

    @DeleteMapping("/delete/{arrayids}")
        public ResponseEntity<?> deleteByIds(@PathVariable(name = "arrayids") List<Long> arrayids){
            for ( Long d : arrayids){
                if(programService.existsById(d)){
                    programService.deleteById(d);
                }
            }
            return ResponseEntity.ok().body("Program has been removed");

        }

//    @PostMapping("/update/{id}")
//    public void updateProgram(@RequestBody Program program, @PathVariable Long id){
//        programService.updateById(program, id);
//    }

    @GetMapping("/all")
    public List<Program> getAllProgram(){
        return programService.getAll();
    }


}
