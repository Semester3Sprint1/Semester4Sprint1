package com.general;

import org.w3c.dom.ls.LSOutput;

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
                    4. Return to Main Menu
                    """);

            int selection = (int) Console.readNumber("Enter Selection: ", 1, 4);
            System.out.println();

            switch (selection) {
                case 1 -> System.out.println("Create Tournament");
                case 2 -> System.out.println("Register Member for Tournament");
                case 3 -> System.out.println("Remove Menu from Tournament");
                case 4 -> {
                    System.out.println("Returning to Main Menu");
                    HomeMenu.show();
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 4");
                    System.out.println();
                }
            }
        }
    }
}
