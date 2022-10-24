package com.general;

import java.sql.Date;
import java.util.ArrayList;

public class Tournament {
   private String name;
    private Date startDate;
    private  Date endDate;
    private  String location;
    private  double entryFee;
   private double cashPrize;
   private ArrayList<Member> memberList;


    public Tournament(String name, Date startDate, Date endDate, String location, double entryFee, double cashPrize, ArrayList<Member> memberList) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
        this.memberList = memberList;
    }

    public Tournament(String name, Date startDate, Date endDate, String location, double entryFee, double cashPrice) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrice;
    }

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
    public double getCashPrize(){
        return this.cashPrize;
    }

    public void setCashPrize(double cashPrize){
        this.cashPrize = cashPrize;
    }

   public String finalStandings;
}