package com.general;

import java.text.NumberFormat;

public abstract class Membership {
    private final static NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private int duration;
    private final double baseCost = 300;

    public Membership(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Duration: " + getDuration();
    }
}
