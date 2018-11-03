package com.encharity.encharity_v1.entities;

import com.encharity.encharity_v1.R;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UrgentPatient {

    @SerializedName("urgentPatientId")
    @Expose
    private Integer urgentPatientId;
    @SerializedName("urgentPhotoId")
    @Expose
    private Integer urgentPhotoId;
    @SerializedName("urgentFullname")
    @Expose
    private String urgentFullname;
    @SerializedName("urgentCategory")
    @Expose
    private String urgentCategory;
    @SerializedName("urgentDescription")
    @Expose
    private String urgentDescription;
    @SerializedName("urgentTotalTenge")
    @Expose
    private String urgentTotalTenge;
    @SerializedName("urgentFundedPercent")
    @Expose
    private String urgentFundedPercent;
    @SerializedName("urgentDaysLeft")
    @Expose
    private String urgentDaysLeft;
    @SerializedName("urgentCity")
    @Expose
    private String urgentCity;

    public Integer getUrgentPatientId() {
        return urgentPatientId;
    }

    public void setUrgentPatientId(Integer urgentPatientId) {
        this.urgentPatientId = urgentPatientId;
    }

    public Integer getUrgentPhotoId() {
        return urgentPhotoId;
    }

    public void setUrgentPhotoId(Integer urgentPhotoId) {
        this.urgentPhotoId = urgentPhotoId;
    }

    public String getUrgentFullname() {
        return urgentFullname;
    }

    public void setUrgentFullname(String urgentFullname) {
        this.urgentFullname = urgentFullname;
    }

    public String getUrgentCategory() {
        return urgentCategory;
    }

    public void setUrgentCategory(String urgentCategory) {
        this.urgentCategory = urgentCategory;
    }

    public String getUrgentDescription() {
        return urgentDescription;
    }

    public void setUrgentDescription(String urgentDescription) {
        this.urgentDescription = urgentDescription;
    }

    public String getUrgentTotalTenge() {
        return urgentTotalTenge;
    }

    public void setUrgentTotalTenge(String urgentTotalTenge) {
        this.urgentTotalTenge = urgentTotalTenge;
    }

    public String getUrgentFundedPercent() {
        return urgentFundedPercent;
    }

    public void setUrgentFundedPercent(String urgentFundedPercent) {
        this.urgentFundedPercent = urgentFundedPercent;
    }

    public String getUrgentDaysLeft() {
        return urgentDaysLeft;
    }

    public void setUrgentDaysLeft(String urgentDaysLeft) {
        this.urgentDaysLeft = urgentDaysLeft;
    }

    public String getUrgentCity() {
        return urgentCity;
    }

    public void setUrgentCity(String urgentCity) {
        this.urgentCity = urgentCity;
    }

}
