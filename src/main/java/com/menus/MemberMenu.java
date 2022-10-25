package com.menus;

import com.general.Console;
import com.members.AddMember;

public class MemberMenu {

    public static void show(){
        System.out.println("Member Services Menu");
        System.out.println();
        while(true){
            System.out.println("""
                    Please Choose an Option:
                    1. Add Members
                    2. View Current Members
                    3. Remove Member
                    4. Quit
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,4);
            System.out.println();

            switch(selection){
                case 1 -> AddMember.createMember();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
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
