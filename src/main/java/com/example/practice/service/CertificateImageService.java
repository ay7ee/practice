package com.example.practice.service;


import com.example.practice.model.CertificateImage;
import com.example.practice.model.Image;
import com.example.practice.repository.CertificateImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class CertificateImageService {

    @Autowired
    private CertificateImageRepository certificateImageRepository;


    public CertificateImage store(MultipartFile file, Long certificateid) throws IOException {
        CertificateImage certificateImage = new CertificateImage("Certificate", file.getContentType(), file.getBytes(), certificateid);
        return certificateImageRepository.save(certificateImage);
    }

    public CertificateImage getFile(Long id) {
        return certificateImageRepository.findByCertificateID(id);
    }
}
