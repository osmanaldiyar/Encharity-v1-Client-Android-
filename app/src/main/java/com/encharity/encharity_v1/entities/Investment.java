package com.encharity.encharity_v1.entities;

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
