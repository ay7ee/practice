package com.example.practice.repository;

import com.example.practice.model.Program;
import com.example.practice.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
    Optional<Subject> findBySubjectid(Long id);

    String deleteBySubjectid(Long subjectid);

    boolean existsBySubjectid(Long id);

    @Transactional
    @Query("Select new com.example.practice.model.Subject(p.subjectid, p.name, p.credit, p.programid) from Subject p WHERE p.programid = ?1")
    List<Subject> getByProgram(Long programid);
}
