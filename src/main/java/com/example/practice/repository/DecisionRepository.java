package com.example.practice.repository;

import com.example.practice.model.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, Long> {
    @Query("SELECT COUNT(DISTINCT d.requestid) FROM Decision d WHERE d.requestid = ?1 ")
    Long checkIfFinished( Long id );
}
