package com.general;

public class Trial extends Membership {

    public Trial(int duration) {
        super(duration);

        double DISCOUNT = 0;
        super.setMonthlyCost(super.getBaseCost() * DISCOUNT);
    }

    @Override
    public String toString() {
        return "Member Type: Trial\n" + super.toString();
    }
}
