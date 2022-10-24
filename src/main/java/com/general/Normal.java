package com.general;

public class Normal extends Membership {
    private final double DISCOUNT = 0.00;
    private final double monthlyCost;

    public Normal(int duration) {
        super(duration);
        this.monthlyCost = super.getBaseCost() * DISCOUNT;
    }

    @Override
    public String toString() {
        return "Member Type: Normal\n" + super.toString();
    }
}
