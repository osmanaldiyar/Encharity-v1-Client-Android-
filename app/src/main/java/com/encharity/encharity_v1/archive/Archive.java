package com.encharity.encharity_v1.archive;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Archive {

    @SerializedName("archiveId")
    @Expose
    private Integer archiveId;
    @SerializedName("archivePhotoId")
    @Expose
    private Integer archivePhotoId;
    @SerializedName("archiveTitle")
    @Expose
    private String archiveTitle;
    @SerializedName("archiveDescription")
    @Expose
    private String archiveDescription;

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Integer getArchivePhotoId() {
        return archivePhotoId;
    }

    public void setArchivePhotoId(Integer archivePhotoId) {
        this.archivePhotoId = archivePhotoId;
    }

    public String getArchiveTitle() {
        return archiveTitle;
    }

    public void setArchiveTitle(String archiveTitle) {
        this.archiveTitle = archiveTitle;
    }

    public String getArchiveDescription() {
        return archiveDescription;
    }

    public void setArchiveDescription(String archiveDescription) {
        this.archiveDescription = archiveDescription;
    }

}

/*
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
*/
