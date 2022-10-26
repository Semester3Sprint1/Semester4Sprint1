package com.members.membership;

public class Normal extends Membership {
    private final int DURATION_IN_DAYS;
    private final double DISCOUNT_RATE;

    public Normal() {
        this.DURATION_IN_DAYS = 365;
        this.DISCOUNT_RATE = 0;
    }

    public Normal(int DURATION_IN_DAYS, double discount){
        this.DURATION_IN_DAYS = DURATION_IN_DAYS;
        this.DISCOUNT_RATE = discount;
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
        return "Member Type: Normal\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" + "Cost: " + getFormat().format(getCost());
    }
}
