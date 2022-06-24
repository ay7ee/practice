package com.example.practice.repository;


import com.example.practice.model.Image;
import com.example.practice.model.Program;
import com.example.practice.model.enums.Status_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    @Transactional
    @Query("Select new com.example.practice.model.Program(p.programid, p.name, p.code, p.universityid) from Program p WHERE p.universityid = ?1")
    List<Program> findByUniversityid(Long universityid);

    @Transactional
    @Query("Select new com.example.practice.model.Program(p.programid, p.name, p.code, p.universityid) from Program p WHERE p.programid = ?1")
    Optional<Program> findById(Long programid);

    @Transactional
    @Modifying
    @Query("update Program r set r.name = :name, r.code = :code where r.programid = :id")
    void update(@Param("name") String code, @Param("name") String name, @Param("requestid") Long id);



    String deleteByProgramid(Long programid);
    boolean existsByProgramid(Long programid);
}
