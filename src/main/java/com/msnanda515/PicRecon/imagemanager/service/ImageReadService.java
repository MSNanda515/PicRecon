package com.msnanda515.PicRecon.imagemanager.service;

import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageReadService {
    private final ImageRepo imageRepo;

    @Autowired
    ImageReadService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public Image readImage(String imageId, String ownerId) {
        // Get the image from the database
        // TODO: Check if user has permission
        Optional<Image> imageOptional = imageRepo.findImageById(imageId);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            return image;
        }
        return new Image();

        // Verify if the user has permission to view the file
        // Return the file if the user has permission
    }
}
