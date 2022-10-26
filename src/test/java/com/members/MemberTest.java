package com.members;

import com.members.membership.Membership;
import com.members.membership.Normal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {
    Address address = new Address("120 Anywhere St.", "Anywhere", "A0K 0U0", "NL","Canada");
    Membership membership = new Normal();
    Member member = new Member("Cody", "Barrett", address, "codybarrett@email.com", 1002, "01/01/1990", membership);

    @Test

    public void testGetFirstName() {
        String result = member.getFirstName();
        String expectedResult = "Cody";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetLastName(){
        String result = member.getLastName();
        String expectedResult = "Barrett";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetAddress(){
        Address result = member.getAddress();
        Address expectedResult = address;
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetEmail(){
        String result = member.getEmail();
        String expectedResult = "codybarrett@email.com";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetMemberID(){
        int result = member.getMemberID();
        int expectedResult = 1002;
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetStartDate(){
        String result = member.getStartDate();
        String expectedResult = "01/01/1990";
        Assertions.assertEquals(result, expectedResult);
    }

    @Test

    public void testGetMembership(){
        Membership result = member.getMembership();
        Membership expectedResult = membership;
        Assertions.assertEquals(result, expectedResult);
    }

    }


