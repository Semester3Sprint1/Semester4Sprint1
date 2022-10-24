package com.general;

import java.util.Date;

public class Member extends Person{

    private  final String memberID;
    private final  Date startDate;
    private Membership membership;



    public Member(String firstName, String lastName, Address address, String email, String memberID,  Membership membership) {
        super(firstName, lastName, address, email);
        Date date = new Date();
        this.memberID = memberID;
        this.startDate = date;
        setMembership(membership);
    }

    public String getMemberID() {
        return memberID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Membership getMembership() {
        return membership;
    }


    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString(){
        return("Member ID:" + getMemberID() + "\n" + super.toString() + "\n" + getMembership()  + "Start Date:"+ getStartDate());
    }
}
