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
    private ImageAnalysisService imageAnalysisService;

    private final ImageRepo imageRepo;

    // Todo: Replace with actual URL
    private String localPath = Constants.localPath;

    @Autowired
    ImageUploadService(ImageRepo imageRepo, FileUploadService fileUploadService,
                       ImageAnalysisService imageAnalysisService) {
        this.imageRepo = imageRepo;
        this.fileUploadService = fileUploadService;
        this.imageAnalysisService = imageAnalysisService;
    }

    public void uploadImage(MultipartFile file, String ownerId) {
        // TODO: Use multithreading to access mongodb server and cloud vision api
        // Create an image object and save it to the database
        Image im = new Image(ownerId);
        // Changes the current object with the id
        imageRepo.insert(im);
        // Construct the url for the frontend
        im.setImageLoc(Constants.localPath + im.getId());
        im.setImageUrl(Constants.serverUrl + Constants.apiEndpoint + "image?imageId=" + im.getId());
        // Save the image to the local file
        fileUploadService.uploadToLocal(file, im.getId());

        // Get labels for the image
        im.setLabels(imageAnalysisService.imageLabels(im.getImageUrl()));

        // Save the object to database
        imageRepo.save(im);
    }
}
