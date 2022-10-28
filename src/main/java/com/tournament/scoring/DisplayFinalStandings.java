package com.tournament.scoring;

import com.general.Console;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;
import com.tournament.scoring.DisplayScores;

public class DisplayFinalStandings {

    public static void show(){

        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name: ", 3, 200), SearchForTournament.tList);
            if( tournamentToUse != null){
                DisplayScores.displayScores(tournamentToUse);
                break;
            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }
        }
    }
}
