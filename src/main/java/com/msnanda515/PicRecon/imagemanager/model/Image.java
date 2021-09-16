package com.msnanda515.PicRecon.imagemanager.model;

import org.springframework.data.annotation.Id;

public class Image {
    @Id
    private long id;

    private long ownerId;

    public Image() {}

    public Image(long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return String.format(
                "Image[id=%s, Owner='%s']",
                id, ownerId);
    }
}
