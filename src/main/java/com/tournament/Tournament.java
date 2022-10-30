package com.tournament;

import com.general.DateCheck;
import com.general.DateValidator;
import com.members.Member;


import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Tournament {
    private int tournamentID;
    private String name;
    private Date startDate;
    private Date endDate;
    private String location;
    private double entryFee;
    private Tournament tournament;

   public static int  tournamentCount = 0;

    // this list stores Members by Tournament
   private ArrayList<Member> memberList = new ArrayList<>();

    // Constructors


    public Tournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Tournament (){
        this.name = "undefined";
        this.location = "undefined";
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

    public Tournament(int tournamentID, String name, Date startDate, Date endDate, String location, double entryFee){
        setTournamentID(tournamentID);
        setName(name);
        this.startDate = startDate;
        this.endDate = endDate;
        setLocation(location);
        setEntryFee(entryFee);
    }


    // Getters


    public Tournament getTournament() {
        return tournament;
    }

    public String getName() {
        return name;
    }

    public Date getStartDateObject(){
        return startDate;
    }

    public Date getEndDateObject(){
        return endDate;
    }


    public String getStartDate(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String startDateString = df.format(this.startDate);

        return startDateString;
    }


    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    //Setters

    public void setEndDate(String date){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date endDate = null;
        try {
            endDate = df.parse(date);
            this.endDate =  endDate;
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

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    // Adds Member to Tournament

    public void addMember(Member member){
        memberList.add(member);
    }

    public void deleteMember(Member member){
        memberList.remove(member);
    }

    // Display Tournament Member List

    public void displayTournamentParticipants(){
        System.out.println(getName() + " Member Participants");
        System.out.println("ID" + " " + "Member Name");
        System.out.println("--" + " " + "-----------");
        memberList.stream()
                .sorted(Comparator.comparing(Member::getName))
                .forEach(m-> System.out.println(m.getMemberID() + "  " + m.getName()));
    }
    // designed for Lambda filtering
    public int tournamentDateCheck(){
        DateValidator validator = new DateCheck(this.startDate, new Date());
        int value = validator.dateCheck();
        return value;
    }

    // String Output

    @Override
    public String toString(){
        return("Tournament Name: " + getName() + " Location " + getLocation() + "\nStartDate: " + getStartDate() + " End Date: " + getEndDate()
                + " Entry Fee: " + NumberFormat.getCurrencyInstance().format(getEntryFee()));
    }
}
