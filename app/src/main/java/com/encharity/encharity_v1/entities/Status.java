package com.encharity.encharity_v1.entities;

public class Status {

    private String description;
    private String dateTime;

    public static Status[] statusArray = {
            new Status("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do "
                    + "\n" + "eiusmod tempor incididunt ut labore et dolore magna aliqua.","2 days ago"),
            new Status("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do "
                    + "\n" + "eiusmod tempor incididunt ut labore et dolore magna aliqua.","2 days ago"),
            new Status("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do "
                    + "\n" + "eiusmod tempor incididunt ut labore et dolore magna aliqua.","2 days ago"),
            new Status("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do "
                    + "\n" + "eiusmod tempor incididunt ut labore et dolore magna aliqua.","2 days ago"),
            new Status("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do "
                    + "\n" + "eiusmod tempor incididunt ut labore et dolore magna aliqua.","2 days ago")
    };

    private Status(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return description + "\n" + "\t" + dateTime;
    }
}
