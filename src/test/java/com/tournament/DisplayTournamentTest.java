package com.tournament;

import com.general.Console;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class DisplayTournamentTest {


    @Test
    public void displayTournamentTest(){
        DisplayTournaments.show();
    }

    @Test
    public void displayTournamentByMember(){

        CompetitiveTournament t1 = new CompetitiveTournament("Mike Open", "03/23/2022", "03/30/2022", "The House", 500, 5000);
        ArrayList<Tournament> tList = new ArrayList<>();
        tList.add(t1);
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)){
            console.when(() ->Console.readLine("Enter Tournament Name: ", 3, 200)).thenReturn("Mike Open");
            DisplayTournaments.displayMemberByTournament(tList);
        }
        tList.clear();
    }

}
