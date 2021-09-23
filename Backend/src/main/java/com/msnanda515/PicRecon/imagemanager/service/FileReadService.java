package com.msnanda515.PicRecon.imagemanager.service;
import com.msnanda515.PicRecon.imagemanager.Constants;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FileReadService {

    private String uploadFolderPath = Constants.localPath;

    public byte[] getImage(String imageId) {
        try {
            Path path = Paths.get(uploadFolderPath + imageId);
            return Files.readAllBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
