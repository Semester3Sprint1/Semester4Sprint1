package com.general;

public class Normal extends Membership {

    public Normal(int duration) {
        super(duration);

        double DISCOUNT = 1;
        super.setMonthlyCost(super.getBaseCost() * DISCOUNT);
    }

    @Override
    public String toString() {
        return "Member Type: Normal\n" + super.toString();
    }
}
