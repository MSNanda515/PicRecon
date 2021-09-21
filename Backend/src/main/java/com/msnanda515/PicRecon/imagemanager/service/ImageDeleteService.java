package com.msnanda515.PicRecon.imagemanager.service;

import com.msnanda515.PicRecon.imagemanager.Constants;
import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageDeleteService {
    private final ImageRepo imageRepo;
    private FileDeleteService fileDeleteService;

    // Todo: Replace with actual URL
    private String localPath = Constants.localPath;

    @Autowired
    ImageDeleteService(ImageRepo imageRepo,
                       FileDeleteService fileDeleteService) {
        this.imageRepo = imageRepo;
        this.fileDeleteService = fileDeleteService;
    }

    public void deleteImage(String imageId, String userId) {
        // Get the image details from the db
        // Should be working but isn't
        Optional<Image> imageOptional = imageRepo.findImageById(imageId);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            if (image.getOwnerId().equals(userId)) {
                fileDeleteService.deleteFromLocal(image.getImageLoc());
                imageRepo.deleteImageById(imageId);
                // Also delete the file locally
            }
        }
    }
}
