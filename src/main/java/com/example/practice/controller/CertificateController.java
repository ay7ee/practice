package com.example.practice.controller;


import com.example.practice.model.Certificate;
import com.example.practice.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("/create")
    public void saveCertificate(@RequestBody Certificate certificate){
        certificateService.createCertificate(certificate);
    }

    @GetMapping("/{id}")
    public Optional<Certificate> getCertificate(@PathVariable(value = "id") Long id){
        return certificateService.getCertificate(id);
    }

    @GetMapping("/user/{id}")
    public Optional<Certificate> getCertificateByUserID(@PathVariable(value = "id") Long id){
        return certificateService.getCertificateByUserId(id);
    }
}
