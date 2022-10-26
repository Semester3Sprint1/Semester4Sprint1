package com.members.membership;

import java.text.NumberFormat;

public abstract class Membership {
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private final double baseCost = 300;
    private int DURATION_IN_DAYS;
    private double DISCOUNT_RATE;
    private int typeCode;

    public int getTypeCode() {
        return typeCode;
    }

    public int getDURATION_IN_DAYS() {
        return DURATION_IN_DAYS;
    }

    public double getDISCOUNT_RATE() {
        return DISCOUNT_RATE;
    }

    public double getCost() {
        return baseCost;
    }

    protected NumberFormat getFormat(){
        return formatter;
    }
}
