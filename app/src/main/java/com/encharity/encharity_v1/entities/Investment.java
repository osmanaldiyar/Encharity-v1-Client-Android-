package com.encharity.encharity_v1.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Investment {

    @SerializedName("investmentId")
    @Expose
    private Long investmentId;
    @SerializedName("amountOfInvestment")
    @Expose
    private String amountOfInvestment;
    @SerializedName("dateOfInvestment")
    @Expose
    private String dateOfInvestment;

    public Long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
    }

    public String getAmountOfInvestment() {
        return amountOfInvestment;
    }

    public void setAmountOfInvestment(String amountOfInvestment) {
        this.amountOfInvestment = amountOfInvestment;
    }

    public String getDateOfInvestment() {
        return dateOfInvestment;
    }

    public void setDateOfInvestment(String dateOfInvestment) {
        this.dateOfInvestment = dateOfInvestment;
    }

    @Override
    public String toString() {
        return amountOfInvestment + " " + dateOfInvestment;
    }
}

/*
public class Investment {

    private String amountOfInvestment;
    private String dateOfInvestment;

    public static Investment[] investmentsArray = {
            new Investment("500 KZT","April 13, 2017, 20:02:14"),
            new Investment("10 000 KZT","March 9, 2017, 14:15:02"),
            new Investment("1000 KZT","February 23, 2017, 8:50:44")
    };

    private Investment(String amountOfInvestment, String dateOfInvestment) {
        this.amountOfInvestment = amountOfInvestment;
        this.dateOfInvestment = dateOfInvestment;
    }

    @Override
    public String toString() {
        return amountOfInvestment + " " + dateOfInvestment;
    }
}
*/
