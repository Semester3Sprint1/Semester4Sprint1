package com.general;

public class SpecialOffer extends Membership {
    private final double DISCOUNT = 0.00;
    private final double monthlyCost;

    public SpecialOffer(int duration) {
        super(duration);
        this.monthlyCost = super.getBaseCost() * DISCOUNT;
    }

    @Override
    public String toString() {
        return "Member Type: Special Offer\n" + super.toString();
    }
}
