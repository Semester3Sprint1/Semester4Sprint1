package com.menus;

import com.general.Console;
import com.menus.Interfaces.MenuHome;

public class HomeMenu  implements MenuHome {



    public  void show(){

        System.out.println("Mcllroy Country Club Management System");
        System.out.println();

        while(true){
            System.out.println("""
                    Please Choose an Option:
                        1. Member Services
                        2. Tournament Menu
                        3. Quit
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,3);
            System.out.println();

            switch(selection){
                case 1 -> MemberMenu.show();
                case 2 -> TournamentMenu.show();
                case 3  -> {
                    System.out.println("Closing Program");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 3");
                    System.out.println();
                }
            }
        }

    }
}
