package com.tournament.scoring;

import com.members.Address;
import com.members.Member;
import com.members.membership.Membership;
import com.tournament.CharityTournament;
import com.tournament.Tournament;
import com.tournament.scoring.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)

public class TestScore {


    @Test

    public void testDefaultScore() {
        Address mockAddress = mock(Address.class);
        Membership mockMembership = mock(Membership.class);

        Member member = new Member("Cody", "Barrett", mockAddress, "cody@email.com", 1000, "01/01/1090", mockMembership);
        Tournament testTournament = new CharityTournament(1, "Mike Open", new Date("03/23/2022"), new Date(), "The House", 500, "Mike Foundation");
        Score score = new Score(member, testTournament);

        assertEquals(0, score.getScore());
    }

    public static ArrayList<Score> scoreList = new ArrayList<>();

    @Test

    public void testScore() {
        Address mockAddress = mock(Address.class);
        Membership mockMembership = mock(Membership.class);


        Member member = new Member("Cody", "Barrett", mockAddress, "cody@email.com", 1000, "01/01/1090", mockMembership);
        Tournament testTournament = new CharityTournament(1, "Mike Open", new Date("03/23/2022"), new Date(), "The House", 500, "Mike Foundation");
        Score score = new Score(10, member, testTournament);

        assertEquals(10, score.getScore());

    }

    @Test

    public void testSetScore(){
        Address mockAddress = mock(Address.class);
        Membership mockMembership = mock(Membership.class);

        Member member = new Member("Cody", "Barrett", mockAddress, "cody@email.com", 1000, "01/01/1090", mockMembership);
        Tournament testTournament = new CharityTournament(1, "Mike Open", new Date("03/23/2022"), new Date(), "The House", 500, "Mike Foundation");
        Score score = new Score(10, member, testTournament);

        ArrayList<Score> scorelist = new ArrayList<>();
        scorelist.add(score);
        Score.setScoreList(scorelist);
    }

    @Test

    public void testGetScore(){
        Address mockAddress = mock(Address.class);
        Membership mockMembership = mock(Membership.class);

        Member member = new Member("Cody", "Barrett", mockAddress, "cody@email.com", 1000, "01/01/1090", mockMembership);
        Tournament testTournament = new CharityTournament(1, "Mike Open", new Date("03/23/2022"), new Date(), "The House", 500, "Mike Foundation");
        Score score = new Score(10, member, testTournament);

        ArrayList<Score> scorelist = new ArrayList<>();
        scorelist.add(score);
        Score.setScoreList(scorelist);

        Assertions.assertTrue(scorelist.toString().contains("Cody"));
    }

    }
