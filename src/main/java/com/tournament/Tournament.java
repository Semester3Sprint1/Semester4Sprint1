package com.tournament;

import com.members.Member;

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


    // this list stores Members by Tournament
   private ArrayList<Member> memberList = new ArrayList<>();

    // Constructors

    public Tournament (){
        this.name = "Not Available";
        this.location = "Not Available";
        this.entryFee = 0;
        setStartDate("01/01/2000");
        setEndDate("01/01/2000");

    }
    public Tournament(String name, String startDate,String  endDate, String location, double entryFee, ArrayList<Member> memberList) {
        setName(name);
        setStartDate(startDate);
        setEndDate(endDate);
        setLocation(location);
        this.entryFee = entryFee;
        this.memberList = memberList;
    }

    public Tournament(String name, String startDate, String endDate, String location, double entryFee){
        setName(name);
        setStartDate(startDate);
        setEndDate(endDate);
        setLocation(location);
        setEntryFee(entryFee);

    }

    // Getters

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
    public String getLocation(){
        return this.location;
    }

    public double getEntryFee(){
        return this.entryFee;
    }

    //Setters

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

    public void setLocation(String location){
        this.location = location;
    }

    public void setEntryFee(double entryFee){
        this.entryFee = entryFee;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Adds Member to Tournament

    public void addMember(Member member){
        memberList.add(member);
    }


    // Display Tournament Member List

    public void displayTournamentParticipants(){
        System.out.println(getName() + " Member Participants");
        memberList.stream()
                .sorted(Comparator.comparing(Member::getName))
                .forEach(m-> System.out.println(m.getName()));
    }

    // String Output

    @Override
    public String toString(){
        return("Tournament Name: " + getName() + " Location " + getLocation() + "\nStartDate: " + getStartDate() + " End Date: " + getEndDate()
                + " Entry Fee: " + NumberFormat.getCurrencyInstance().format(getEntryFee()));
    }
}
