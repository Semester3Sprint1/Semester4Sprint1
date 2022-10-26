package com.tournament;

import com.members.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

        CharityTournament t1 = new CharityTournament(name, startDate, endDate, location, entryFee, charityName);
        CompetitiveTournament t2 = new CompetitiveTournament(name, startDate, endDate, location, entryFee, cashPrize);
        t1.setMoneyRaised(10_000);
        assertEquals(name, t1.getName());
        assertEquals(startDate, t1.getStartDate());
        assertEquals(endDate, t1.getEndDate());
        assertEquals(location, t1.getLocation());
        assertEquals(entryFee, t1.getEntryFee());
        assertEquals(charityName, t1.getCharityName());
        assertEquals(cashPrize, t2.getCashPrize());
        assertEquals(10_000, t1.getMoneyRaised());

    }

    @Test
    public void testAddMemberToTournament(){
         ArrayList<Member> memberList = new ArrayList<>();

    }


    }

