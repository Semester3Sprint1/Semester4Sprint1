package com.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member extends Person{

    private  final String memberID;
    private  Date startDate;
    private Membership membership;



    public Member(String firstName, String lastName, Address address, String email, String memberID, String startDate, Membership membership) {
        super(firstName, lastName, address, email);
        this.memberID = memberID;
        setStartDate(startDate);
        setMembership(membership);
    }



    public String getMemberID() {
        return memberID;
    }



    public String getStartDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String startDateString = df.format(this.startDate);

        return startDateString;
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
        return("Member ID:" + getMemberID() + "\n" + super.toString() + "\n" + getMembership()  + "Start Date:"+ getStartDate());
    }
}
