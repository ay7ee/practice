package com.example.practice.repository;

import com.example.practice.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    @Transactional
    @Query("Select i from Image i WHERE i.userid = ?1 and i.type = ?2 ")
    Optional<Image> findByIdAndType(Long userid, String type);

    @Transactional
    @Query("SELECT i FROM Image i WHERE i.type = ?2 AND i.date = " +
            "(SELECT MAX(i2.date) FROM Image i2 WHERE i2.userid = ?1)")
    Optional<Image> findLastImageByUserIdAndType(Long userid, String type);

}
