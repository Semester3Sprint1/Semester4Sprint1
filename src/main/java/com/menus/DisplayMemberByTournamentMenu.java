package com.menus;

import com.general.Console;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class DisplayMemberByTournamentMenu {

    public static void show(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : "));
            System.out.println();
            if(tournamentToUse != null){
                tournamentToUse.displayTournamentParticipants();
                break;
            }else{
                System.out.println("Error Invalid Tournament Name, Please Try again");
            }
        }


    }
}


