package com.msnanda515.PicRecon.imagemanager.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.IOException;

public class ImageFile {
    // Able to upload an image
    // Able to download an image based on the name
    // Able to model an image file

    @Value("$(imagekit.key)")
    static private String apiKey;

    static private String url = "https://upload.imagekit.io/api/v1/files/upload";

    /**
     * Upload image to the CDS
     * @return
     * boolean depending on whether the request was successful
     */
    static boolean uploadFile(MultipartFile file) throws IOException {
//        // Prepare the http header for the api call
//        HttpHeaders headers = new HttpHeaders();
//        // set custom header
//        headers.set("file", "desktop");
//
//        // build the request
//        HttpEntity request = new HttpEntity(headers);
//
//        // use `exchange` method for HTTP call
//        ResponseEntity<Post> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Post.class, 1);
        return true;
    }
}
