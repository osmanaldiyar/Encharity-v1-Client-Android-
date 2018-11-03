package com.encharity.encharity_v1.blog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Blog{

    @SerializedName("blogId")
    @Expose
    private Integer blogId;
    @SerializedName("blogPhotoId")
    @Expose
    private Integer blogPhotoId;
    @SerializedName("blogTitle")
    @Expose
    private String blogTitle;
    @SerializedName("blogDescription")
    @Expose
    private String blogDescription;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getBlogPhotoId() {
        return blogPhotoId;
    }

    public void setBlogPhotoId(Integer blogPhotoId) {
        this.blogPhotoId = blogPhotoId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }
}

/*
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
*/
