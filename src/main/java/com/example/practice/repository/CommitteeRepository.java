package com.example.practice.repository;

import com.example.practice.model.Committee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitteeRepository extends JpaRepository<Committee, Long> {

    @Query("Select new com.example.practice.model.Committee(c.committeeid, c.requestid, c.userid) FROM Committee c where c.userid = ?1")
    List<Committee> findAllByUserid(Long id);


    @Query("Select new com.example.practice.model.Committee(c.committeeid, c.requestid, c.userid) FROM Committee c where c.requestid = ?1")
    List<Committee> findAllByRequestid(Long id);
    Long countCommitteeByRequestid( Long requestid );
}
