package com.tournament.scoring;

import com.members.AddMember;
import com.members.Member;
import com.tournament.CreateTournament;
import com.tournament.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindScoreTest {
    @Test
    public void testFindScore_withList(){
        Tournament defaultTourney = CreateTournament.createDefaultTournament("C");
        Member defaultMember = AddMember.createDefaultMember();

        defaultTourney.addMember(defaultMember);
        Score.getScoreList().add(new Score(defaultMember, defaultTourney));

        Score searchedScore = FindScore.findScore(defaultMember, defaultTourney, Score.getScoreList());
        searchedScore.setScore(5);
        Assertions.assertEquals(searchedScore.getScore(), 5);
    }

    @Test
    public void testFindScore(){
        Tournament defaultTourney = CreateTournament.createDefaultTournament("C");
        Member defaultMember = AddMember.createDefaultMember();

        defaultTourney.addMember(defaultMember);
        Score.addScore(new Score(defaultMember, defaultTourney));

        Score searchedScore = FindScore.findScore(defaultMember, defaultTourney);
        searchedScore.setScore(5);
        Assertions.assertEquals(searchedScore.getScore(), 5);
    }
}
