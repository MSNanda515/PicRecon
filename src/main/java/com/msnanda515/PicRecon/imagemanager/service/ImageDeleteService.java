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

    // Todo: Replace with actual URL
    private String localPath = Constants.localPath;

    @Autowired
    ImageDeleteService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public void deleteImage(String imageId, String userId) {
        // Get the image details from the db
        imageRepo.deleteImageById(imageId);
        // Should be working but isn't
        // TODO: Should verify if the image exists in the database before deleting
//        Optional<Image> imageOptional = imageRepo.findImageById(imageId);
//        imageOptional.ifPresent(im -> {
//            // Check if user has permission to delete
//            if (im.getOwnerId() == userId) {
//                // Delete the post
//                System.out.println("Image Deleted");
//            }
//        });
        // Delete the file
    }
}
