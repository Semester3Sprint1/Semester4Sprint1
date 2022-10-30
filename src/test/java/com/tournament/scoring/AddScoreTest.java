package com.tournament.scoring;

import com.database.TournamentDetail;
import com.members.AddMember;
import com.members.Member;
import com.tournament.CreateTournament;

import com.tournament.Tournament;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddScoreTest {

    @Mock
    private TournamentDetail mockDBInsert;

    @Test
    public void testAddScore(){
        Member defaultMember = AddMember.createDefaultMember();
        Tournament defaultTournament = CreateTournament.createDefaultTournament("C");
        Tournament otherDefaultTournament = CreateTournament.createDefaultTournament("T");
        otherDefaultTournament.setName("Other Boy");
        defaultTournament.addMember(defaultMember);

        Score theScore = new Score(defaultMember, defaultTournament);
        Score.addScore(theScore);

        AddScore.addScore(mockDBInsert, defaultTournament, defaultMember, Score.getScoreList(), 3);
    }
}
