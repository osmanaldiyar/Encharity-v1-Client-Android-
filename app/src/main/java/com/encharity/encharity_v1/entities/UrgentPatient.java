package com.encharity.encharity_v1.entities;

import com.encharity.encharity_v1.R;

public class UrgentPatient {

    private int photoId;
    private String fullname;
    private String category;
    private String description;
    private String totalTenge;
    private String fundedPercent;
    private String daysLeft;
    private String city;

    public static final UrgentPatient[] URGENT_PATIENTS = {
            new UrgentPatient(R.drawable.kid1,"Pavlov Ivan Petrovich","Urgent" ,
                    "Urgent Lorem ipsum sit amet, consectetur adipiscing elit, sed do " +
                            "eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "150 000 KZT","10%","256 days left","Russia, Moscow"),
            new UrgentPatient(R.drawable.kid2,"Alekseev Nikita Sergeevich","Urgent" ,
                    "Urgent Lorem ipsum amet, consectetur adipiscing elit, sed do " +
                            "eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    "250 000 KZT","60%","26 days left","Russia, St.Petersburg")
    };

    private UrgentPatient(int photoId, String fullname, String category, String description, String totalTenge,
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

}
