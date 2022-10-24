package com.general;

import java.text.NumberFormat;

public abstract class Membership {
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private int duration;
    private double monthlyCost;
    private double baseCost;

    public Membership(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public String getFormatter() {
        return formatter.format(getMonthlyCost());
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public String toString() {
        return "Duration: " + getDuration() + "\n" +
                "Total Cost: " + getFormatter();
    }
}
