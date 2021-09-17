package com.msnanda515.PicRecon.imagemanager.controller;

import com.msnanda515.PicRecon.imagemanager.service.FileUploadService;
import com.msnanda515.PicRecon.imagemanager.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.zip.ZipException;

@RestController
@RequestMapping("api/v1")
public class ImageController {

    private ImageUploadService imageUploadService;

    @Autowired
    ImageController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload/local")
    public void uploadLocal(@RequestParam("file")MultipartFile multipartFile,
                            @RequestParam("ownerId") String ownerId) throws IOException, ZipException {
        // Call the service to upload file
        imageUploadService.uploadImage(multipartFile, ownerId);
    }

    @DeleteMapping("/delete/local")
    public void deleteLocal(@RequestParam("imageId") Long imageId, @RequestParam("ownerId") Long ownerId) {
        // Delete the image from the database if the image belongs to the owner

    }
}
