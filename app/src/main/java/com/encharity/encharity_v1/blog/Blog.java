package com.encharity.encharity_v1.blog;

import com.encharity.encharity_v1.R;

public class Blog {

    private int photoId;
    private String title;
    private String description;

    public static final Blog[] blogItems = {
            new Blog(R.drawable.kid2,"Post1",
                    "Blog description description description description description"),
            new Blog(R.drawable.kid2,"2nd Post",
                    "Description description description description description description"),
            new Blog(R.drawable.kid2,"Interesting post 3",
                    "Description description description description description description")
    };

    private Blog(int photoId, String title, String description) {
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
