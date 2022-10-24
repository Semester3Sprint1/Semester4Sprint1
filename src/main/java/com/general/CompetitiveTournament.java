package com.general;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CompetitiveTournament extends Tournament{

    private double cashPrize;

    public CompetitiveTournament(String name, String startDate, String endDate, String location, double entryFee, ArrayList<Member> memberList, double cashPrize) {
        super(name, startDate, endDate, location, entryFee, memberList);
        this.cashPrize = cashPrize;
    }

    public CompetitiveTournament(String name, String startDate, String endDate, String location, double entryFee, double cashPrize) {
        super(name, startDate, endDate, location, entryFee);
        this.cashPrize = cashPrize;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    @Override
    public String toString(){
        return(super.toString() + " Cash Prize " + NumberFormat.getCurrencyInstance().format(getCashPrize()));
    }
}
