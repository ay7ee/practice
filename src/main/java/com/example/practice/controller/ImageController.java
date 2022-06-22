package com.example.practice.controller;


import com.example.practice.model.Image;
import com.example.practice.model.models.ImageResponse;
import com.example.practice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping(value = "/create", consumes = { "multipart/form-data" })
    public ResponseEntity<String> store(@RequestParam("image") MultipartFile file, String type, Long userid){
        try {
            imageService.save(file, type, userid);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Optional<Image> fileEntityOptional = imageService.getImage(id);

        if (!fileEntityOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        Image fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getImage());
    }

    @GetMapping("/user/{id}/{type}")
    public String showImageByUserIdAndType(@PathVariable("id") Long id, @PathVariable("type") String type) {

        Optional<Image> image = imageService.getLastImageByUserIdAndType(id, type);

        if(image.isPresent()) {
            String imageId =image.get().getImageid();
            String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/")
                    .path(imageId)
                    .toUriString();
            return downloadURL;
        }
        return "not found";
    }

    @GetMapping
    public List<ImageResponse> list() {
        return imageService.getAllImages()
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/url/{id}")
    public String getImageUrl(@PathVariable("id") String id) {
        Optional<Image> image =  imageService.getImage(id);
        if(image.isPresent()) {
            String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/")
                    .path(id)
                    .toUriString();
            return downloadURL;
        }
        return "not found";
    }

    private ImageResponse mapToFileResponse(Image fileEntity) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/image/")
                .path(fileEntity.getImageid())
                .toUriString();
        ImageResponse fileResponse = new ImageResponse();
        fileResponse.setId(fileEntity.getImageid());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setType(fileEntity.getType());
        fileResponse.setDate(fileEntity.getDate());
        fileResponse.setUserid(fileEntity.getUserid());
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }


}

