package com.example.practice.service;


import com.example.practice.model.Certificate;
import com.example.practice.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public void createCertificate(Certificate certificate){
        certificateRepository.save(certificate);
    }

    public Optional<Certificate> getCertificate(Long id){
        return certificateRepository.findById(id);
    }

    public Optional<Certificate> getCertificateByUserId(Long id) {
        return certificateRepository.findByUserid(id);
    }
}
