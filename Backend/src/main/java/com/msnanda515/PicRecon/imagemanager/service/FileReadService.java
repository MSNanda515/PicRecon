//package com.msnanda515.PicRecon.imagemanager.service;

//import org.springframework.core.io.Resource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

//@Service
//public class FileReadService {
//    public ResponseEntity<Resource> downloadFile(String filename, String fileLoc) throws IOException {
//        Path filePath;
//
//        filePath = Paths.get(fileLoc);
//        if(!Files.exists(filePath)) {
//            throw new FileNotFoundException(filename + " was not found on the server");
//        }
//
//
//        Resource resource = new UrlResource(filePath.toUri());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("File-Name", filename);
//        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + filename);
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
//                .headers(httpHeaders).body(resource);
//    }
//}
