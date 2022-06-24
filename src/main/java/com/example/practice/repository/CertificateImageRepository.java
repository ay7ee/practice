package com.example.practice.repository;

import com.example.practice.model.CertificateImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CertificateImageRepository extends JpaRepository<CertificateImage, Long> {

    @Transactional
    @Query("select i from CertificateImage i where i.certificateid = ?1")
    CertificateImage findByCertificateID(Long id);

    @Transactional
    CertificateImage findByCertificateid(Long id);
}
