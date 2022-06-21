package com.example.practice.repository;

import com.example.practice.model.Profile;
import com.example.practice.model.User;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

     Optional<Profile> getByUserid(Long id);

}
