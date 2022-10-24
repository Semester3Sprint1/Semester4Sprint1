package com.general;

public class Trial extends Membership {
    private final double DISCOUNT = 0.00;
    private final double monthlyCost;

    public Trial(int duration) {
        super(duration);
        this.monthlyCost = super.getBaseCost() * DISCOUNT;
    }

    @Override
    public String toString() {
        return "Member Type: Trial\n" + super.toString();
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }
}
