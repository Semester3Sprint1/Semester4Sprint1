package com.menus;

import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.CreateTournament;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class TournamentMenu {

    public static void show() {
        System.out.println("Tournament Menu");
        System.out.println();

        while (true) {
            System.out.println("""
                    Please Choose an Option:
                    1. Create Tournament
                    2. Register Member 
                    3. Remove Member
                    4. Display Participating Member by Tournament 
                    5. Edit Tournament Details
                    6. Return to Main Menu
                    """);

            int selection = (int) Console.readNumber("Enter Selection: ", 1, 6);
            Console.nextLine();
            System.out.println();

            switch (selection) {
                case 1 -> CreateTournament.userInput();
                case 2 -> AddMemberToTournamentMenu.show();
                case 3 -> RemoveMemberFromTournamentMenu.show();
                case 4 -> DisplayMemberByTournamentMenu.show();
                case 5 -> System.out.println("Edit Tournament Details");
                case 6 -> {
                    System.out.println("Returning to Main Menu");
                    HomeMenu.show();
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 6");
                    System.out.println();
                }
            }
        }
    }
}
