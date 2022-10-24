package com.general;

public class Normal extends Membership {
    private final int DURATION_IN_DAYS = 365;
    private final double DISCOUNT_RATE = 1;

    @Override
    public double getCost() {
        return super.getCost() * this.DISCOUNT_RATE;
    }

    public int getDURATION_IN_DAYS() {
        return DURATION_IN_DAYS;
    }
    @Override
    public String toString() {
        return "Member Type: Special Offer\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" + "Cost: " + getFormat().format(getCost());
    }
}
