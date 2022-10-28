package com.members.membership;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpecialOfferTest {
    @Test
    public void specialMemberTest(){
        SpecialOffer membership = new SpecialOffer(60, 0.5);

        Assertions.assertEquals(membership.getCost(), 150);
        Assertions.assertEquals(membership.getTypeCode(), 3);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 60);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0.5);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$150.00");

        Assertions.assertEquals(membership.toString(), """
                Member Type: Special Offer
                Duration: 60 days
                Cost: $150.00""");
    }

}
