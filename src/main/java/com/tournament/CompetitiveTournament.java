package com.tournament;

import com.members.Member;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class CompetitiveTournament extends Tournament{

    private double cashPrize;

    //Constructors
    public CompetitiveTournament(int tournamentID, String name, Date startDate, Date endDate, String location, double entryFee, double cashPrize) {
        super(tournamentID, name, startDate, endDate, location, entryFee);
        this.cashPrize = cashPrize;
        tournamentCount++;
    }

    public CompetitiveTournament(String name, String startDate, String endDate, String location, double entryFee, ArrayList<Member> memberList, double cashPrize) {
        super(name, startDate, endDate, location, entryFee, memberList);
        this.cashPrize = cashPrize;
        tournamentCount++;
    }

    public CompetitiveTournament(String name, String startDate, String endDate, String location, double entryFee, double cashPrize) {
        super(name, startDate, endDate, location, entryFee);
        this.cashPrize = cashPrize;
        tournamentCount++;
    }

    //Getters

    public double getCashPrize() {
        return cashPrize;
    }

    //Setters
    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    //String Outputs

    @Override
    public String toString(){
        return(super.toString() + " Cash Prize " + NumberFormat.getCurrencyInstance().format(getCashPrize()));
    }
}
