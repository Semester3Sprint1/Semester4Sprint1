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

    @Test
    public void setAddressTest(){
        Member testMember = AddMember.createDefaultMember();
        Address testAddress = AddMember.getDefaultAddress();
        testAddress.setStreetAddress("52 Bingo Street");

        testMember.setAddress(testAddress);
        Assertions.assertEquals(testMember.getAddress().getStreetAddress(), "52 Bingo Street");
    }

    @Test
    public void setEmailTest(){
        Member testMember = AddMember.createDefaultMember();
        String newEmail = "fakeEmail@email.com";
        testMember.setEmail(newEmail);

        Assertions.assertEquals(testMember.getEmail(), newEmail);
    }
}
