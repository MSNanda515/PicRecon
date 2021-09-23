package com.msnanda515.PicRecon.imagemanager.service;

import com.msnanda515.PicRecon.imagemanager.Constants;
import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.repo.ImageRepo;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

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
        Image im = new Image(ownerId);
        // Changes the current object with the id
        imageRepo.insert(im);
        // Construct the url for the frontend
        im.setImageLoc(Constants.localPath + im.getId());
        im.setImageUrl(Constants.serverUrl + Constants.apiEndpoint + "image?imageId=" + im.getId());
        imageRepo.save(im);
        // Save the image to the local file
        fileUploadService.uploadToLocal(file, im.getId());

    }
}
