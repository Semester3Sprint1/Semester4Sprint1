package com.tournament.scoring;

import com.general.Console;
import com.members.AddMember;
import com.members.Member;
import com.members.membership.Membership;
import com.tournament.CreateTournament;
import com.tournament.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class DisplayStandingTest {
    @Test
    public void testDisplayStanding(){
        Tournament defaultTourney = CreateTournament.createDefaultTournament("C");
        Member defaultMember = AddMember.createDefaultMember();

        defaultTourney.addMember(defaultMember);
        Score.getScoreList().add(new Score(defaultMember, defaultTourney));

        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)){
            console.when(() -> Console.readLine("Enter Tournament Name: ", 3, 200))
                    .thenReturn("Fireball").thenReturn("PG Open");

            DisplayFinalStandings.show();
        }



    }
}
