package com.msnanda515.PicRecon.imagemanager.controller;

import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.service.FileReadService;
import com.msnanda515.PicRecon.imagemanager.service.ImageDeleteService;
import com.msnanda515.PicRecon.imagemanager.service.ImageReadService;
import com.msnanda515.PicRecon.imagemanager.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipException;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;


@RestController
@RequestMapping("api/v1")
public class ImageController {

    private ImageUploadService imageUploadService;
    private ImageDeleteService imageDeleteService;
    private ImageReadService imageReadService;
    private FileReadService fileReadService;

    @Autowired
    ImageController(ImageUploadService imageUploadService,
                    ImageDeleteService imageDeleteService,
                    ImageReadService imageReadService,
                    FileReadService fileReadService) {
        this.imageUploadService = imageUploadService;
        this.imageDeleteService = imageDeleteService;
        this.imageReadService = imageReadService;
        this.fileReadService = fileReadService;
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

    // TODO: Delete the all endpoint
    @GetMapping("/get/local/all")
    public List<Image> getAllImages() {
        // Call the service to read and return the image
        return imageReadService.readAllImages();
    }

    @PostMapping("/upload/local")
    public void uploadLocal(@RequestParam("ownerId") String ownerId,
                            @RequestParam(value="imageFile", required = false)MultipartFile multipartFile) throws IOException, ZipException {
        // Call the service to upload file
        imageUploadService.uploadImage(multipartFile, ownerId);
    }

    @DeleteMapping("/delete/local")
    public void deleteLocal(@RequestParam("imageId") String imageId, @RequestParam("ownerId") String ownerId) {
        // Delete the image from the database if the image belongs to the owner
        imageDeleteService.deleteImage(imageId, ownerId);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFiles(@RequestParam("filepath") String filepath,
                                                  @RequestParam("imageId") String imageId) throws IOException {
        Path filePath = Paths.get(filepath);
        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(imageId + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", imageId);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .headers(httpHeaders).body(resource);
    }

    @GetMapping(value="/image", produces=MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@RequestParam("imageId") String imageId) throws IOException {
        return fileReadService.getImage(imageId);
    }
}
