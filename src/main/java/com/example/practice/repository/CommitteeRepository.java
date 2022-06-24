package com.example.practice.repository;

import com.example.practice.model.Committee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommitteeRepository extends JpaRepository<Committee, Long> {

    @Query("Select new com.example.practice.model.Committee(c.committeeid, c.requestid, c.userid) FROM Committee c where c.userid = ?1")
    List<Committee> findAllByUserid(Long id);


    @Query("Select new com.example.practice.model.Committee(c.committeeid, c.requestid, c.userid) FROM Committee c where c.requestid = ?1")
    List<Committee> findAllByRequestid(Long id);

    @Query("SELECT COUNT(d.requestid) FROM Committee d WHERE d.requestid = ?1 ")
    Long countCommitteeByRequestid( Long requestid );

    @Transactional
    @Query("select p.requestid from Committee p WHERE p.userid = ?1")
    List<Long> getIds(Long userid);

}
