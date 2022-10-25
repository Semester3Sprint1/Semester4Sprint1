package com.menus;

import com.general.Console;

public class ReportMenu {

    public static void show() {

        System.out.println("Report Menu");
        System.out.println();

        while (true) {
            System.out.println("""
                    Please Choose an Option:
                    1. Member List
                    2. Members List by Tournament
                    3. Member by Current Tournaments Actively Participating In
                    4. Member by Past Tournaments  Previously Participated In
                    5. Member by Upcoming Tournaments they are Registered to  Participate In
                    6. Membership Duration by Member
                    7. Return to Main Menu
                    """);
            int selection = (int) Console.readNumber("Enter Selection: ", 1, 7);
            System.out.println();


            switch (selection) {
                case 1 -> System.out.println("Member List");
                case 2 -> System.out.println("Member List by Tournament");
                case 3 -> System.out.println("Current");
                case 4 -> System.out.println("Previously");
                case 5 -> System.out.println("Upcoming");
                case 6 -> System.out.println("Membership Duration");
                case 7 -> HomeMenu.show();
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 7");
                    System.out.println();
                }
            }
        }
    }
}
