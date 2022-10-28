package com.tournament;

import com.general.Console;

public class DisplayTournaments {
    public static void show(){
        SearchForTournament.tList
                .forEach(m-> System.out.println(m.getName()));
    }

    public static void displayMemberByTournament(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name: ", 3, 200), SearchForTournament.tList);
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
