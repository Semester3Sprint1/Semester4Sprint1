package com.members.membership;

import com.general.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class OtherTest {
    @Test
    public void otherTest(){
        Other membership = new Other(60, 0.5);

        Assertions.assertEquals(membership.getCost(), 150);
        Assertions.assertEquals(membership.getTypeCode(), 5);
        Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 60);
        Assertions.assertEquals(membership.getDISCOUNT_RATE(), 0.5);

        Assertions.assertEquals(membership.getFormat().format(membership.getCost()), "$150.00");

        Assertions.assertEquals(membership.toString(), """
                Member Type: Other
                Duration: 60 days
                Cost: $150.00""");
    }

    @Test
    public void otherTest_withoutConstructor() {
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
            console.when(() -> Console.readNumber("Enter membership duration: ", 1, 365)).thenReturn(100.0);
            console.when(() -> Console.readNumber("Enter the discount provided by this membership: (##) ", 0, 100)).thenReturn(50.0);

            Other membership = new Other();

            Assertions.assertEquals(membership.getDURATION_IN_DAYS(), 100);
        }
    }
}
