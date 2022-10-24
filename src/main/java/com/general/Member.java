package com.general;

import java.util.Date;

public class Member extends Person{

    private  final String memberID;
    private final  Date startDate;
    private Membership membership;



    public Member(String firstName, String lastName, Address address, String email, String memberID, Date startDate, Membership membership) {
        super(firstName, lastName, address, email);
        this.memberID = memberID;
        this.startDate = startDate;
        this.membership = membership;
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
}
