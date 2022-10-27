package com.tournament;

import com.general.Console;

public class DisplayFinalStandings {

    public static void show(){

        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : ", 3, 200), SearchForTournament.tList);
            if( tournamentToUse != null){
                DisplayScores.displayScores(tournamentToUse);
                break;
            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }
        }
    }
}
