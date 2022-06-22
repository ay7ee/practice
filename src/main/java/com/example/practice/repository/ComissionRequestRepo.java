package com.example.practice.repository;

import com.example.practice.model.ComissionRequest;
import com.example.practice.model.enums.Status_comission_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ComissionRequestRepo extends JpaRepository<ComissionRequest, Long> {


    @Transactional
    @Modifying
    @Query("update ComissionRequest r set r.status_comission_request = :status where r.comissionRequestId = :id")
    void updateStatus(@Param("status") Status_comission_request status, @Param("id") Long id);

}
