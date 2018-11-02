package com.encharity.encharity_v1.archive;

import com.encharity.encharity_v1.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Archive {


    private int photoId;
    private String title;
    private String description;

    public static final Archive[] archiveItems = {
            new Archive(R.drawable.kid1,"title",
                    "Description description description description description description"),
            new Archive(R.drawable.kid1,"title2",
                    "Description description description description description description"),
            new Archive(R.drawable.kid1,"title3",
                    "Description description description description description description")
    };

    private Archive(int photoId, String title, String description) {
        this.photoId = photoId;
        this.title = title;
        this.description = description;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
