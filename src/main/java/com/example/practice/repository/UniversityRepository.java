package com.example.practice.repository;

import com.example.practice.model.Request;
import com.example.practice.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    @Query("Select new com.example.practice.model.University(r.universityid, r.address, r.code, r.fullname, r.name,  r.url, r.userid) FROM University r WHERE r.universityid = :id")
    Optional<University> getUniversity(@Param("id")  Long id);

    @Query("Select new com.example.practice.model.University(r.universityid, r.address, r.code, r.fullname, r.name,  r.url, r.userid) FROM University r WHERE r.name like :name OR r.fullname like :name")
    Optional<University> getUniversityByName(@Param("name")  String name);

    @Query("Select new com.example.practice.model.University(r.universityid, r.address, r.code, r.fullname, r.name,  r.url, r.userid) FROM University r")
    List<University> getAll();
}
