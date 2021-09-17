package com.msnanda515.PicRecon.imagemanager.model;

import org.springframework.data.annotation.Id;

import java.util.Random;

public class Image {
    @Id

    private long id;

    private long ownerId;
    private String imageLoc;
    public Image() {}

    public Image(long ownerId, String imageLoc) {
        // Todo Generate a sequence of long (range is hardcoded)
        Random rand = new Random();
        id = rand.nextInt(100);
        this.ownerId = ownerId;
        this.imageLoc = imageLoc;
    }


    @Override
    public String toString() {
        return String.format(
                "Image[id=%s, Owner='%s']",
                id, ownerId);
    }
}
