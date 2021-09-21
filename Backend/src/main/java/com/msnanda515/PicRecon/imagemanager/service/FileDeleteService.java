package com.msnanda515.PicRecon.imagemanager.service;

import com.msnanda515.PicRecon.imagemanager.Constants;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileDeleteService {
    private String deleteFolderPath = Constants.localPath;

    public void deleteFromLocal(String fileLoc) {
        try {
            Path path = Paths.get(fileLoc);
            Files.deleteIfExists(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
