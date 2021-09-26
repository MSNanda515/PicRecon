package com.msnanda515.PicRecon.imagemanager.service;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature.Type;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.servlet.ModelAndView;

/**
 * Performs image analysis such as label detection using google cloud
 * vision API
 */
@Service
public class ImageAnalysisService {

    private CloudVisionTemplate cloudVisionTemplate;
    private ResourceLoader resourceLoader;

    @Autowired
    public ImageAnalysisService(CloudVisionTemplate cloudVisionTemplate,
                                ResourceLoader resourceLoader) {
        this.cloudVisionTemplate = cloudVisionTemplate;
        this.resourceLoader = resourceLoader;
    }

    public ArrayList<String> imageLabels(String imageUrl) {
        AnnotateImageResponse response =
                this.cloudVisionTemplate.analyzeImage(
                        this.resourceLoader.getResource(imageUrl), Type.LABEL_DETECTION);

        Map<String, Float> imageLabels =
                response.getLabelAnnotationsList().stream()
                        .collect(
                                Collectors.toMap(
                                        EntityAnnotation::getDescription,
                                        EntityAnnotation::getScore,
                                        (u, v) -> {
                                            throw new IllegalStateException(String.format("Duplicate key %s", u));
                                        },
                                        LinkedHashMap::new));
        ArrayList<String> labelList = new ArrayList<>();
        for (String label : imageLabels.keySet()) {
            labelList.add(label);
        }
        return labelList;
        // [END spring_vision_image_labelling]

    }
}
