package com.example.practice.controller;


import com.example.practice.model.CertificateImage;
import com.example.practice.service.CertificateImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/certificateImage")
public class CertificateImageController {

    @Autowired
    private CertificateImageService certificateImageService;

    @PostMapping(value = "/create", consumes = { "multipart/form-data" })
    public String store(@RequestParam("file") MultipartFile file, @RequestParam("certificateid") Long certificateid){

        try {
            certificateImageService.store(file, certificateid);
            return "File uploaded";
        } catch (Exception e) {
            return "Error";

        }
    }

    @GetMapping("/certificate/{id}")
    @ResponseBody
    void showImage(@PathVariable("id") Long id, HttpServletResponse response, CertificateImage product)
            throws ServletException, IOException {
        product = certificateImageService.getFile(id);
        response.setContentType(product.getType());
        response.getOutputStream().write(product.getCertificate_image());
        response.getOutputStream().close();
    }
}
