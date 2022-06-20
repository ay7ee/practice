package com.example.practice.service;


import com.example.practice.model.Image;
import com.example.practice.model.Profile;
import com.example.practice.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image store(MultipartFile file , String type , Long userid) throws IOException {
        Image image = new Image( file.getBytes(), type , userid);
        return imageRepository.save(image);
    }

    public Image getFile(Long id) {
        return imageRepository.findById(id).get();
    }

    public Image getFileByType(Long id, String type) {
        return imageRepository.findByIdAndType(id, type);
    }


}
