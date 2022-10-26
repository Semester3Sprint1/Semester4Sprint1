package com.members.membership;

import com.general.Console;

public class Other extends  Membership {
    private final int DURATION_IN_DAYS;
    private final double DISCOUNT_RATE;
    private final int typeCode = 5;

    public Other() {
        this.DURATION_IN_DAYS = (int) Console.readNumber("Enter membership duration: ", 1, 365);
        this.DISCOUNT_RATE = (Console.readNumber("Enter the discount provided by this membership: (##)", 0, 100) / 100);
    }

    public Other(int duration, double discount){
        this.DURATION_IN_DAYS = duration;
        this.DISCOUNT_RATE = discount;
    }

    @Override
    public double getCost() {
        return super.getCost() * (1.0 - this.DISCOUNT_RATE);
    }

    @Override
    public int getDURATION_IN_DAYS() {
        return DURATION_IN_DAYS;
    }

    @Override
    public double getDISCOUNT_RATE() {
        return DISCOUNT_RATE;
    }

    public int getTypeCode() {
        return typeCode;
    }

    @Override
    public String toString() {
        return "Member Type: Other\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" + "Cost: " + getFormat().format(getCost());
    }
}
