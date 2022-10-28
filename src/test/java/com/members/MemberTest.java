package com.members;

import com.members.membership.Membership;
import com.members.membership.Normal;
import com.menus.MemberMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class MemberTest {
    Address address = new Address("120 Anywhere St.", "Anywhere", "A0K 0U0", "NL","Canada");
    Membership membership = new Normal();

    Member member = new Member("Cody", "Barrett", address, "codybarrett@email.com", 0, "01/01/1990", membership);

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

        int expectedResult = 0;

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

    @Test
    public void testConstructor(){
        Member newMember = new Member("Alex", "Ridgeley", AddMember.getDefaultAddress(),
                "aridgeley@msn.com", "10/10/1991", new Normal());

        Assertions.assertEquals(newMember.getEmail(), "aridgeley@msn.com");
    }

    @Test
    public void testLoadConstructor(){
        Member newMember = new Member("Alex", "Ridgeley", AddMember.getDefaultAddress(),
                "aridgeley@msn.com", 1, new Date(), new Normal());

        Assertions.assertEquals(newMember.getEmail(), "aridgeley@msn.com");
    }

    @Test
    public void testSetStartDate(){
        Member testMember = AddMember.createDefaultMember();
        Assertions.assertThrows(RuntimeException.class, () -> testMember.setStartDate("13, 14, 22"));
    }

    @Test
    public void testGetStartDateAsDate(){
        Member testMember = AddMember.createDefaultMember();

        System.out.println(testMember.getStartDateAsDate());
        Assertions.assertEquals(testMember.getStartDateAsDate(), new Date(testMember.getStartDate()).toInstant());
    }
}


