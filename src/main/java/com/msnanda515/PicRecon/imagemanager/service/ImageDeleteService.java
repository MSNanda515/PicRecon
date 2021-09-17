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

    public void deleteImage(String imageId, String ownerId) {
//        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
//        if (studentOptional.isPresent()) {
//            throw new IllegalStateException("Email Taken");
//        }
//        studentRepository.save(student);
        // Get the image details from the db
//        Optional<Image> imOptional = imageRepo.find
        // Check if user has permission to delete

        // Delete the file
    }
}
