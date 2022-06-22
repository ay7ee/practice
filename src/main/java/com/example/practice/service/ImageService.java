package com.example.practice.service;


import com.example.practice.model.Image;
import com.example.practice.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public void save(MultipartFile file, String type , Long userid) throws IOException {

        Image fileEntity = new Image();
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setImage(file.getBytes());
        fileEntity.setSize(file.getSize());

        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        fileEntity.setDate(timeStamp);

        fileEntity.setType(type);
        fileEntity.setUserid(userid);

        imageRepository.save(fileEntity);
    }

    public Optional<Image> getImage(String id) {
        return imageRepository.findById(id);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Optional<Image> getFileByType(Long id, String type) {
        return imageRepository.findByIdAndType(id, type);
    }

    public Optional<Image> getLastImageByUserIdAndType(Long id, String type) {
        return imageRepository.findLastImageByUserIdAndType(id, type);
    }

}
