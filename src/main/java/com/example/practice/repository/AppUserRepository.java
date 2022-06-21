package com.example.practice.repository;

import com.example.practice.model.Role;
import com.example.practice.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1 ")
    int enableAppUser(String email);


    @Query("SELECT u.userid from User u WHERE u.email = ?1")
    Long getUserIdByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u " + "SET u.role = :role WHERE  u.email = :email")
    void updateRole(@Param(value = "email") String email, @Param(value = "role") Role role);



    @Query("SELECT u from User u WHERE u.email like %?1%")
    List<User> findAllByEmailLikeIgnoreCase(String email);

    Optional<User> getUserByUserid(Long userid);
}
