package com.msnanda515.PicRecon.imagemanager.service.serviceImpl;

import com.msnanda515.PicRecon.imagemanager.Constants;
import com.msnanda515.PicRecon.imagemanager.model.Image;
import com.msnanda515.PicRecon.imagemanager.repo.ImageRepo;
import com.msnanda515.PicRecon.imagemanager.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    private String uploadFolderPath = Constants.localPath;

    private ImageRepo imageRepo;

    @Autowired
    FileUploadServiceImpl(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    /**
     * Uploads file to local file system. Ideally should be replaced by remote service
     * @param file
     */

    @Override
    public void uploadToLocal(MultipartFile file, String ownerId) {
        // Save the object to the server
        try {
            // Convert the file to bytes
            byte[] data = file.getBytes();
            // Get the path to upload folder
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            // Write the file to the path
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
