package com.tournament;

import com.members.Member;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class CharityTournament  extends Tournament{

    private double moneyRaised;
    private String charityName;

    //Constructors

    public CharityTournament(String name, Date startDate, Date endDate, String location, double entryFee, String charityName) {
        super(name, startDate, endDate, location, entryFee);
        this.moneyRaised = moneyRaised;
        this.charityName = charityName;
        tournamentCount++;
    }

    public CharityTournament(String name, String startDate, String endDate, String location, double entryFee, String charityName) {
        super(name, startDate, endDate, location, entryFee);
        setCharityName(charityName);
        tournamentCount++;

    }

    public CharityTournament(String name, String startDate, String endDate, String location, double entryFee, ArrayList<Member> memberList, String charityName) {
        super(name, startDate, endDate, location, entryFee, memberList);
        setCharityName(charityName);
        tournamentCount++;
    }

    //Getters
    public double getMoneyRaised() {
        return moneyRaised;
    }

    public String getCharityName() {
        return charityName;
    }

    //Setters

    public void setMoneyRaised(double moneyRaised) {
        this.moneyRaised = moneyRaised;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    //Output String
    @Override

    public String toString(){
        return(super.toString() + "\nRaised " + NumberFormat.getCurrencyInstance().format(getMoneyRaised()) + " for " + getCharityName());
    }
}
