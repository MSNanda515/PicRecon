package com.msnanda515.PicRecon.imagemanager.repo;

import com.msnanda515.PicRecon.imagemanager.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Serves as the data access layer and offers persistence in the data stored
 * Used for CRUD operations on the database
 */
public interface ImageRepo extends MongoRepository<Image, Long> {
}
