package com.members.membership;

import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;

import java.util.ArrayList;

public class Family extends Membership {
    private final int DURATION_IN_DAYS;
    private final double DISCOUNT_RATE;
    ArrayList<Integer> familyMembers = new ArrayList<>();

    public Family() {
        this.DURATION_IN_DAYS = 365;
        while (true){
            int memID = (int) Console.readNumber("Enter the Member ID of each additional family member, or enter 0 to finish", 0);
            if (memID == 0) break;
            Member searchedMember = SearchForMember.findMember(memID);
            if (searchedMember != null) familyMembers.add(searchedMember.getMemberID());
        }

        if (familyMembers.size() > 5) this.DISCOUNT_RATE = 0.5;
        else this.DISCOUNT_RATE = familyMembers.size() / 10.0;
    }

    public Family(int duration, double DISCOUNT_RATE, ArrayList<Integer> familyMembers) {
        this.DURATION_IN_DAYS = duration;
        this.DISCOUNT_RATE = DISCOUNT_RATE;
        this.familyMembers = familyMembers;
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
