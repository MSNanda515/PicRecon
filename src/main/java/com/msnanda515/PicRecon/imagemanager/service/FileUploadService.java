package com.msnanda515.PicRecon.imagemanager.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public void uploadToLocal(MultipartFile file, String ownerId);
}
