package com.tournament;

import com.members.Address;
import com.members.Member;
import com.members.membership.Membership;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class testTournament{

    String name = "Mike Open";
    String startDate = "03/04/2022";
    String endDate = "03/06/2022";
    String location = "18 hole";
    double entryFee = 500;
    String charityName = "RMDH";
    double cashPrize = 5000;




    @Test
    public void testTournamentGettersAndSetters(){

        ArrayList<Member> mockList = mock(ArrayList.class);
        Tournament t3 = new Tournament();
        CharityTournament t1 = new CharityTournament(name, startDate, endDate, location, entryFee, charityName);
        CompetitiveTournament t2 = new CompetitiveTournament(name, startDate, endDate, location, entryFee, cashPrize);
        CompetitiveTournament t4 = new CompetitiveTournament("PG Open", "06/01/2022", "06/02/2022", "18 Hole Course", 5000, mockList, 10_000);
        t1.setMoneyRaised(10_000);
        assertEquals(name, t1.getName());
        assertEquals(startDate, t1.getStartDate());
        assertEquals(endDate, t1.getEndDate());
        assertEquals(location, t1.getLocation());
        assertEquals(entryFee, t1.getEntryFee());
        assertEquals(charityName, t1.getCharityName());
        assertEquals(cashPrize, t2.getCashPrize());
        assertEquals(10_000, t1.getMoneyRaised());
        assertEquals("Not Available", t3.getName());
        assertTrue(t1.toString().contains("RMDH"));
        assertTrue(t2.toString().contains("$5,000"));
        t2.setCashPrize(10_000);
        assertTrue(t2.toString().contains("$10,000"));


    }

    @Test
    public void testAddMemberToTournament(){

        Address mockAddress = mock(Address.class);
        Membership mockMembership = mock(Membership.class);
        Member member = new Member("Cody", "Barrett", mockAddress, "codybarrett@email.com", 0, "01/01/1990", mockMembership);
        Member member1 = new Member("Mike", "Wadden", mockAddress, "mike@email.com", 1, "01/01/1990", mockMembership);
        CharityTournament t1 = new CharityTournament(name, startDate, endDate, location, entryFee, charityName);
        t1.addMember(member);
        t1.addMember(member1);
        assertEquals(2,t1.getMemberList().size());
        assertEquals("Mike Wadden", t1.getMemberList().get(1).getName());
         t1.deleteMember(member);
        assertEquals(1,t1.getMemberList().size());
        assertEquals("Mike Wadden", t1.getMemberList().get(0).getName());







    }


    }

