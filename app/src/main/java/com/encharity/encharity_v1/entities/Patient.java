package com.encharity.encharity_v1.entities;

import com.encharity.encharity_v1.R;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Patient {

    @SerializedName("patientId")
    @Expose
    private int patientId;
    @SerializedName("photoId")
    @Expose
    private Integer photoId;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("totalTenge")
    @Expose
    private String totalTenge;
    @SerializedName("fundedPercent")
    @Expose
    private String fundedPercent;
    @SerializedName("daysLeft")
    @Expose
    private String daysLeft;
    @SerializedName("city")
    @Expose
    private String city;

    /*public Patient(int patientId, int photoId, String fullname, String category, String description, String totalTenge,
                   String fundedPercent, String daysLeft, String city) {
        this.patientId = patientId;
        this.photoId = photoId;
        this.fullname = fullname;
        this.category = category;
        this.description = description;
        this.totalTenge = totalTenge;
        this.fundedPercent = fundedPercent;
        this.daysLeft = daysLeft;
        this.city = city;
    }*/

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotalTenge() {
        return totalTenge;
    }

    public void setTotalTenge(String totalTenge) {
        this.totalTenge = totalTenge;
    }

    public String getFundedPercent() {
        return fundedPercent;
    }

    public void setFundedPercent(String fundedPercent) {
        this.fundedPercent = fundedPercent;
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(String daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

/*public class Patient {

    private int photoId;
    private String fullname;
    private String category;
    private String description;
    private String totalTenge;
    private String fundedPercent;
    private String daysLeft;
    private String city;

        public static final Patient[] PATIENTS = {
                new Patient(R.drawable.kid1,"Ivanov Ivan Ivanovich","All" ,
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                                "eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        "150 000 KZT","10%","256 days left","Russia, Moscow"),
                new Patient(R.drawable.kid2,"Petrov Petr Petrovich","All" ,
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                                "eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        "250 000 KZT","60%","26 days left","Russia, St.Petersburg")
        };

    public Patient(int photoId, String fullname, String category, String description, String totalTenge,
                   String fundedPercent, String daysLeft, String city) {
        this.photoId = photoId;
        this.fullname = fullname;
        this.category = category;
        this.description = description;
        this.totalTenge = totalTenge;
        this.fundedPercent = fundedPercent;
        this.daysLeft = daysLeft;
        this.city = city;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getTotalTenge() {
        return totalTenge;
    }

    public String getFundedPercent() {
        return fundedPercent;
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public String getCity() {
        return city;
    }

}*/
