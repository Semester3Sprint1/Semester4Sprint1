package com.members.membership;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialTest {
    @Test
    public void trialTest(){
        Trial membership = new Trial();

        Assertions.assertEquals(membership.getCost(), 0);
        Assertions.assertEquals(membership.getTypeCode(), 2);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 30);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 1);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$0.00");

        Assertions.assertEquals(membership.toString(), """
                Member Type: Trial
                Duration: 30 days
                Cost: $0.00""");
    }

    @Test
    public void trialTest_withConstructor(){
        Trial membership = new Trial(60, 0.5);

        Assertions.assertEquals(membership.getCost(), 150);
        Assertions.assertEquals(membership.getTypeCode(), 2);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 60);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0.5);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$150.00");

        Assertions.assertEquals(membership.toString(), """
                Member Type: Trial
                Duration: 60 days
                Cost: $150.00""");
    }
}
