package com.menus;

import com.database.InsertTournament;
import com.general.Console;
import com.tournament.*;
import com.tournament.scoring.DisplayFinalStandings;
import com.tournament.scoring.AddScore;


public class TournamentMenu {

    public static void show() {

        InsertTournament insert = new InsertTournament();

        System.out.println("Tournament Menu");
        System.out.println();

        while (true) {
            System.out.println();
            System.out.println("""
                    Please Choose an Option:
                    1. Create Tournament
                    2. Register Member 
                    3. Remove Member
                    4. Display Participating Member by Tournament 
                    5. Enter Member Tournament Score
                    6. View All Tournaments
                    7. View Tournament Results
                    8. Return to Main Menu
                    """);

            int selection = (int) Console.readNumber("Enter Selection: ", 1, 8);
            Console.nextLine();
            System.out.println();

            switch (selection) {
                case 1 -> CreateTournament.userInput(insert);
                case 2 -> AddTournamentMember.show();
                case 3 -> RemoveTournamentMember.show();
                case 4 -> DisplayTournaments.displayMemberByTournament(SearchForTournament.tList);
                case 5 -> AddScore.addScore();
                case 6 -> DisplayTournaments.show();
                case 7 -> DisplayFinalStandings.show();
                case 8 -> {
                    System.out.println("Returning to Main Menu");
                    HomeMenu.show();
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 7");
                    System.out.println();
                }
            }
        }
    }
}
