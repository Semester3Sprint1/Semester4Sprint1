package com.menus;

import com.general.Console;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class DisplayMemberByTournamentMenu {

    public static void show(){
        // finds the tournament by its name
        Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : "));
        tournamentToUse.displayTournamentParticipants();
    }
}


