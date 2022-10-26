package com.members.membership;

public class Trial extends Membership {
    private final int DURATION_IN_DAYS;
    private final double DISCOUNT_RATE;
    private final int typeCode = 2;

    public Trial() {
        this.DURATION_IN_DAYS = 15;
        this.DISCOUNT_RATE = 1;
    }

    public Trial(int DURATION_IN_DAYS, double DISCOUNT_RATE) {
        this.DURATION_IN_DAYS = DURATION_IN_DAYS;
        this.DISCOUNT_RATE = DISCOUNT_RATE;
    }

    @Override
    public double getCost() {
        return super.getCost() * (1 - this.DISCOUNT_RATE);
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
        return "Member Type: Trial\n" + "Duration: " + this.DURATION_IN_DAYS + " days\n" + "Cost: " + getFormat().format(getCost());
    }
}
