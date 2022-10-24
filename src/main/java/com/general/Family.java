package com.general;

import java.util.ArrayList;
import java.util.HashMap;

public class Family extends Membership {
    private final int DURATION_IN_DAYS = 365;
    private final double DISCOUNT_RATE;
    ArrayList<String> familyMembers = new ArrayList<>();

    public Family() {
        while (true){
            String memID = Console.readString("Enter the Member ID of each additional family member, or enter \"DONE\" to finish");
            if (memID.equals("DONE")) break;
            Member searchedMember = SearchForMember.findMember(memID);
            if (searchedMember != null) familyMembers.add(searchedMember.getMemberID() + " - " + searchedMember.getName());
        }

        if (familyMembers.size() > 5) this.DISCOUNT_RATE = 0.5;
        else this.DISCOUNT_RATE = familyMembers.size() / 10.0;
    }

    @Override
    public double getCost() {
        return super.getCost() * (1 - this.DISCOUNT_RATE);
    }

    public int getDURATION_IN_DAYS() {
        return DURATION_IN_DAYS;
    }

    @Override
    public String toString() {
        return "Member Type: Family Plan\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" +
                "Cost: " + getFormat().format(getCost()) + "\n" +
                "Family members on plan: " + familyMembers;
    }
}
