package com.example.practice.repository;

import com.example.practice.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Transactional
    @Query("Select i from Image i WHERE i.userid = ?1 and i.type = ?2")
    Image findByIdAndType(Long userid, String type);
}
