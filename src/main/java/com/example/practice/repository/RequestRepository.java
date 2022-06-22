package com.example.practice.repository;

import com.example.practice.model.Request;
import com.example.practice.model.enums.Status_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    @Transactional
    @Modifying
    @Query("update Request r set r.status_request = :status_request where r.requestid = :requestid")
    void updateStatus(@Param("status_request") Status_request status_request, @Param("requestid") Long requestid);


    @Query("Select new com.example.practice.model.Request(r.requestid, r.userid, r.universityid, r.certificateid, r.programid,  r.status_request) FROM Request r WHERE r.userid = :id")
    Optional<Request> findAllByUserid(@Param("id")  Long id);
}

