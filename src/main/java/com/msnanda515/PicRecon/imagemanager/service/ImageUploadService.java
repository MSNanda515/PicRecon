package com.msnanda515.PicRecon.imagemanager.service;

import com.msnanda515.PicRecon.imagemanager.Constants;
import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Updates the file info in mongodb server and puts the image in the local file structure
 */
@Service
public class ImageUploadService {

    private FileUploadService fileUploadService;

    private final ImageRepo imageRepo;

    // Todo: Replace with actual URL
    private String localPath = Constants.localPath;

    @Autowired
    ImageUploadService(ImageRepo imageRepo, FileUploadService fileUploadService) {
        this.imageRepo = imageRepo;
        this.fileUploadService = fileUploadService;
    }

    public void uploadImage(MultipartFile file, String ownerId) {
        // Create an image object and save it to the database
        Image im = new Image(ownerId, localPath + file.getOriginalFilename());
        imageRepo.insert(im);
        // Save the image to the local file
        fileUploadService.uploadToLocal(file, ownerId);
    }
}
