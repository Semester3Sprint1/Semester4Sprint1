package com.members.membership;

import com.general.Console;

public class Other extends  Membership {
    private final int DURATION_IN_DAYS;
    private final double DISCOUNT_RATE;

    public Other() {
        this.DURATION_IN_DAYS = (int) Console.readNumber("Enter membership duration: ", 1, 365);
        this.DISCOUNT_RATE = Console.readNumber("Enter the discount provided by this membership: ", 0.00, 1.00);
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
        return "Member Type: Other\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" + "Cost: " + getFormat().format(getCost());
    }
}
