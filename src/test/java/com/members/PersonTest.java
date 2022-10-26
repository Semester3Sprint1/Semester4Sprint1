package com.members;

import com.members.membership.Membership;
import com.members.membership.Normal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Membership membership = new Normal();
    Address address = new Address("120 Anywhere St.", "Anywhere", "A0K 0U0", "NL","Canada");
    Person person = new Member("Cody", "Barrett", address, "codybarrett@email.com", 1002, "01/01/1990", membership);

    @Test

    public void getNameTest() {
        String result = person.getName();
        String expectedResult = "Cody Barrett";
        Assertions.assertEquals(result, expectedResult);
    }

}
