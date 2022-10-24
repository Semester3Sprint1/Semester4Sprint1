package com.general;

public class SpecialOffer extends Membership {
    private final int DURATION_IN_DAYS = 60;
    private final double DISCOUNT_RATE = 0.5;

    @Override
    public double getCost() {
        return super.getCost() * this.DISCOUNT_RATE;
    }

    public int getDURATION_IN_DAYS() {
        return DURATION_IN_DAYS;
    }

    @Override
    public String toString() {
        return "Member Type: Trial\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" + "Cost: " + getFormat().format(getCost());
    }
}
