package com.general;

import java.text.NumberFormat;

public abstract class Membership {
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private final double baseCost = 300;

    public double getCost() {
        return baseCost;
    }

    protected NumberFormat getFormat(){
        return formatter;
    }
}
