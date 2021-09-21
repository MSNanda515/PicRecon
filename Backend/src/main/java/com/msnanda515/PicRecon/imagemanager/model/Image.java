package com.msnanda515.PicRecon.imagemanager.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class Image {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;

    private String ownerId;
    private String imageLoc;
    public Image() {}

    public Image(String ownerId, String imageLoc) {
        // Todo Generate a sequence of long (range is hardcoded)
        this.ownerId = ownerId;
        this.imageLoc = imageLoc;
    }

    public Image(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return String.format(
                "Image[id=%s, Owner='%s']",
                id, ownerId);
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getImageLoc() {
        return imageLoc;
    }

    public void setImageLoc(String imageLoc) {
        this.imageLoc = imageLoc;
    }
}
