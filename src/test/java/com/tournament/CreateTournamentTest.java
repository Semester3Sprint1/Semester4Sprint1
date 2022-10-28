package com.tournament;

import com.database.InsertTournament;
import com.general.Console;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateTournamentTest {

    @Mock
    private InsertTournament mockDBInsert;


    @Test
    public void loadCompetitiveTournamentTest(){
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)){
            console.when(() ->Console.readLine("Enter Tournament Name: ", 5, 200)).thenReturn("Mike Open");
            console.when(()->Console.readStringDate("Enter Tournament Start Date (03/22/2022) format: ")).thenReturn("03/23/2022");
            console.when(() ->Console.readStringDate("Enter Tournament End Date (03/22/2022) format: ")).thenReturn("03/23/2022");
            console.when(() ->Console.readLine("Enter Tournament Location: ", 5, 200)).thenReturn("The House");
            console.when(() ->Console.readNumber("Enter Entry fee: ", 0)).thenReturn(500.00);
            console.when(() -> Console.readChar("Enter Tournament Type (C) Charity or (T) Competitive: " , "C", "T")).thenReturn("T");
            console.when(() -> Console.readNumber("Enter Cash Prize: ", 1000, 100_000)).thenReturn(5000.00);
            CreateTournament.userInput(mockDBInsert);
        }
    }

    @Test
    public void loadCharityTournamentTest(){
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)){
            console.when(() ->Console.readLine("Enter Tournament Name: ", 5, 200)).thenReturn("Mike Open");
            console.when(()->Console.readStringDate("Enter Tournament Start Date (03/22/2022) format: ")).thenReturn("03/23/2022");
            console.when(() ->Console.readStringDate("Enter Tournament End Date (03/22/2022) format: ")).thenReturn("03/23/2022");
            console.when(() ->Console.readLine("Enter Tournament Location: ", 5, 200)).thenReturn("The House");
            console.when(() ->Console.readNumber("Enter Entry fee: ", 0)).thenReturn(500.00);
            console.when(() -> Console.readChar("Enter Tournament Type (C) Charity or (T) Competitive: " , "C", "T")).thenReturn("C");
            console.when(() -> Console.readLine("Enter Charity Name: ", 3, 150)).thenReturn("Mike Foundation");
            CreateTournament.userInput(mockDBInsert);
        }
    }

    @Test

    public void loadTournamentTest(){
        CreateTournament.loadTournament();
    }

}
