package com.general;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CharityTournament  extends Tournament{

    private double moneyRaised;
    private String charityName;


    public CharityTournament(String name, String startDate, String endDate, String location, double entryFee, String charityName) {
        super(name, startDate, endDate, location, entryFee);
        setCharityName(charityName);

    }

    public CharityTournament(String name, String startDate, String endDate, String location, double entryFee, ArrayList<Member> memberList, String charityName) {
        super(name, startDate, endDate, location, entryFee, memberList);
        setCharityName(charityName);
    }

    public double getMoneyRaised() {
        return moneyRaised;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setMoneyRaised(double moneyRaised) {
        this.moneyRaised = moneyRaised;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    @Override

    public String toString(){
        return(super.toString() + "\nRaised " + NumberFormat.getCurrencyInstance().format(getMoneyRaised()) + " for " + getCharityName());
    }
}
