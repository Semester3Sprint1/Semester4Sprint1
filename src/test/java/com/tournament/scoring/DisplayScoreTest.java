package com.tournament.scoring;

import com.general.Console;
import com.members.AddMember;
import com.members.Member;
import com.tournament.CreateTournament;
import com.tournament.Tournament;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class DisplayScoreTest {

    @Test
    public void testDisplayScores(){
        Tournament defaultTourney = CreateTournament.createDefaultTournament("C");
        Member defaultMember = AddMember.createDefaultMember();

        defaultTourney.addMember(defaultMember);
        Score.getScoreList().add(new Score(defaultMember, defaultTourney));

        DisplayScores.displayScores(Score.getScoreList(), defaultTourney);
    }

    @Test
    public void testDisplayDetailsByMember(){
        Tournament defaultTourney = CreateTournament.createDefaultTournament("C");
        Member defaultMember = AddMember.createDefaultMember();

        defaultTourney.addMember(defaultMember);
        Score.getScoreList().add(new Score(defaultMember, defaultTourney));

        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)){
            console.when(() -> Console.readLine("Enter Tournament Name: ", 3, 200))
                    .thenReturn("Fireball").thenReturn("PG Open");

            DisplayScores.displayTournamentDetailsByMember(Score.getScoreList(), defaultMember.getMemberID());
        }
    }
}
