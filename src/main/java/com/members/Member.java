package com.members;

import com.members.membership.Membership;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Member extends Person{
    private int memberID;
    private Date startDate;
    private Membership membership;

    public Member(String firstName, String lastName, Address address, String email, String startDate, Membership membership) {
        super(firstName, lastName, address, email);
        setStartDate(startDate);
        setMembership(membership);
    }

    public Member(String firstName, String lastName, Address address, String email, int memberID, String startDate, Membership membership) {
        super(firstName, lastName, address, email);
        this.memberID = memberID;
        setStartDate(startDate);
        setMembership(membership);
    }

    public Member(String firstName, String lastName, Address address, String email, int memberID, Date startDate, Membership membership) {
        super(firstName, lastName, address, email);
        this.memberID = memberID;
        this.startDate = startDate;
        setMembership(membership);
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int id){
        this.memberID = id;
    }

    public String getStartDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String startDateString = df.format(this.startDate);

        return startDateString;
    }

    public Instant getStartDateAsDate(){
        return startDate.toInstant();
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setStartDate(String date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(date);
            this.startDate = startDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString(){
        return("Member ID: " + getMemberID() + "\n" + super.toString() + "\n\n" + getMembership()  + "\nStart Date: "+ getStartDate());
    }
}
