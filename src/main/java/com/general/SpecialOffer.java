package com.general;

public class SpecialOffer extends Membership {

    public SpecialOffer(int duration) {
        super(duration);

        double DISCOUNT = 0.5;
        super.setMonthlyCost(super.getBaseCost() * DISCOUNT);
    }

    @Override
    public String toString() {
        return "Member Type: Special Offer\n" + super.toString();
    }
}
