package com.general;

import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Tournament {
   private String name;
    private Date startDate;
    private  Date endDate;
    private  String location;
    private  double entryFee;
   private double cashPrize;
   private ArrayList<Member> memberList = new ArrayList<>();

    // sort past , upcoming , current by date
    public Tournament(String name, String startDate,String  endDate, String location, double entryFee, double cashPrize, ArrayList<Member> memberList) {
        this.name = name;
        setStartDate(startDate);
        setEndDate(endDate);
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
        this.memberList = memberList;
    }

    public Tournament(String name, String startDate, String endDate, String location, double entryFee, double cashPrice) {
        this.name = name;
        setStartDate(startDate);
        setEndDate(endDate);
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrice;
    }


    public String getName() {
        return name;
    }

    public String getStartDate(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String startDateString = df.format(this.startDate);

        return startDateString;
    }

    public void setStartDate(String date){
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(date);
            this.startDate = startDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

    public String getEndDate(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String endDateString = df.format(this.endDate);

        return endDateString;
    }

    public void setEndDate(String date){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date endDate = null;
        try {
            endDate = df.parse(date);
            this.endDate = (Date) endDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(Member member){
        memberList.add(member);
    }

    public void displayTournamentParticipants(){
        System.out.println(getName() + " Member Participants");
        memberList.stream()
                .sorted(Comparator.comparing(Member::getName))
                .forEach(m-> System.out.println(m.getName()));
    }

    public String finalStandings;
    @Override
    public String toString(){
        return("Tournament Name: " + getName() + " Location " + getLocation() + "\nStartDate: " + getStartDate() + " End Date: " + getEndDate()
                + " Entry Fee: " + NumberFormat.getCurrencyInstance().format(getEntryFee()) +  " Cash Prize: " +  NumberFormat.getCurrencyInstance().format(getCashPrize()));
    }
}
