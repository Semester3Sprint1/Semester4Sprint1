package com.general;

public class HomeMenu {

    public static void show(){

        System.out.println("Mcllroy Country Club Management System");
        System.out.println();

        while(true){
            System.out.println("""
                    Please Choose an Option:
                    1. Member Menu
                    2. Tournament Menu
                    3. Reports
                    4. Quit
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,4);
            System.out.println();

            switch(selection){
                case 1 -> System.out.println("Member Section");
                case 2 -> TournamentMenu.show();
                case 3 -> System.out.println("Reports Section");
                case 4  -> {
                    System.out.println("Closing Program");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 4");
                    System.out.println();
                }
            }
        }

    }
}
