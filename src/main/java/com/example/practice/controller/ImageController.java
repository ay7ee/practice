package com.example.practice.controller;


import com.example.practice.model.Image;
import com.example.practice.model.Profile;
import com.example.practice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping(value = "/create", consumes = { "multipart/form-data" })
    public String store(@RequestParam("file") MultipartFile file, String type, Long userid){

        try {
            imageService.store(file, type, userid);
            return "File uploaded";
        } catch (Exception e) {
            return "Error";

        }

    }

    @GetMapping("/{id}")
    @ResponseBody
    void showImage(@PathVariable("id") Long id, HttpServletResponse response, Image product)
            throws ServletException, IOException {
        product = imageService.getFile(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(product.getImage());
        response.getOutputStream().close();
    }

    @GetMapping("/user/{id}/{type}")
    @ResponseBody
    void showImageByUserIdAndType(@PathVariable("id") Long id, @PathVariable("type") String type, HttpServletResponse response, Image product)
            throws ServletException, IOException {
        product = imageService.getFileByType(id, type);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(product.getImage());
        response.getOutputStream().close();
    }


}

