package com.tournament;

import com.general.Console;

import java.util.ArrayList;

public class DisplayTournaments {
    public static void show(){
        System.out.println("ID" + "    " + "Tournament Name");
        System.out.println("--" + "    " + "---------------");
        SearchForTournament.tList
                .forEach(m-> {
                    String output = String.format("%-6s%9s", m.getTournamentID(), m.getName());
                    System.out.println(output);
                });
    }

    public static void displayMemberByTournament(ArrayList<Tournament> tList){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name: ", 3, 200), tList);
            System.out.println();
            if(tournamentToUse != null){
                tournamentToUse.displayTournamentParticipants();
                break;
            } else {
                System.out.println("Error Invalid Tournament Name, Please Try again");
            }
        }
    }
}
