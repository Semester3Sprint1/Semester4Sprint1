package com.general;

import java.sql.Date;

public class Tournament {
    public String name;
    public Date startDate;
    public Date endDate;
    public String location;
    public double entryFee;
    public double cashPrice;

    public Date getStartDate(){
        return this.startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public double getEntryFee(){
        return this.entryFee;
    }

    public void setEntryFee(double entryFee){
        this.entryFee = entryFee;
    }
    public double getCashPrice(){
        return this.cashPrice;
    }

    public void setCashPrice(double cashPrice){
        this.cashPrice = cashPrice;
    }

    public String finalStandings;
}