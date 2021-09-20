package com.msnanda515.PicRecon.imagemanager.controller;

import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.service.FileUploadService;
import com.msnanda515.PicRecon.imagemanager.service.ImageDeleteService;
import com.msnanda515.PicRecon.imagemanager.service.ImageReadService;
import com.msnanda515.PicRecon.imagemanager.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipException;

@RestController
@RequestMapping("api/v1")
public class ImageController {

    private ImageUploadService imageUploadService;
    private ImageDeleteService imageDeleteService;
    private ImageReadService imageReadService;

    @Autowired
    ImageController(ImageUploadService imageUploadService,
                    ImageDeleteService imageDeleteService,
                    ImageReadService imageReadService) {
        this.imageUploadService = imageUploadService;
        this.imageDeleteService = imageDeleteService;
        this.imageReadService = imageReadService;
    }

    @GetMapping("/get/local/image")
    public Image getImage(@RequestParam("imageId") String imageId,
                          @RequestParam("ownerId") String ownerId) {
        // Call the service to read and return the image
        return imageReadService.readImage(imageId, ownerId);
    }

    @GetMapping("/get/local/owner")
    public List<Image> getImages(@RequestParam("ownerId") String ownerId) {
        // Call the service to read and return the image
        return imageReadService.readImagesByOwner(ownerId);
    }

    @PostMapping("/upload/local")
    public void uploadLocal(@RequestParam("file")MultipartFile multipartFile,
                            @RequestParam("ownerId") String ownerId) throws IOException, ZipException {
        // Call the service to upload file
        imageUploadService.uploadImage(multipartFile, ownerId);
    }

    @DeleteMapping("/delete/local")
    public void deleteLocal(@RequestParam("imageId") String imageId, @RequestParam("ownerId") String ownerId) {
        // Delete the image from the database if the image belongs to the owner
        imageDeleteService.deleteImage(imageId, ownerId);
    }
}
