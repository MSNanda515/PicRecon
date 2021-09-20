package com.msnanda515.PicRecon.imagemanager.repo;

import com.msnanda515.PicRecon.imagemanager.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Serves as the data access layer and offers persistence in the data stored
 * Used for CRUD operations on the database
 */
public interface ImageRepo extends MongoRepository<Image, Long> {
    // creates the query that finds the images by ID
    Optional<Image> findImageById(String id);
    void deleteImageById(String id);
    void deleteImageByOwnerId(String ownerId);
    List<Image> findImagesByOwnerId(String ownerId);
}
