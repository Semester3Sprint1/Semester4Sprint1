package com.members.membership;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NormalTest {

    @Test
    public void normalMemberTest(){
        Membership membership = new Normal();

        Assertions.assertEquals(membership.getCost(), 300);
        Assertions.assertEquals(membership.getTypeCode(), 1);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 365);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$300.00");
        
        Assertions.assertEquals(membership.toString(), """
                Member Type: Normal
                Duration: 365 days
                Cost: $300.00""");

    }

    @Test
    public void normalMemberTest_constructor(){
        Normal membership = new Normal(15,0.1);

        Assertions.assertEquals(membership.getCost(), 270);
        Assertions.assertEquals(membership.getTypeCode(), 1);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 15);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0.1);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$270.00");

        Assertions.assertEquals(membership.toString(), """
                Member Type: Normal
                Duration: 15 days
                Cost: $270.00""");
    }

}
