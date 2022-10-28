package com.menus;

import com.general.Console;
import com.members.*;

public class MemberMenu {

    public static void show(){
        boolean returnFlag = false;
        System.out.println("Member Services Menu");
        System.out.println();

        while(!returnFlag){
            System.out.println("""
                    Please Choose an Option:
                        1. Add Member
                        2. View All Members
                        3. View Member Details
                        4. Back to Main
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,4);
            System.out.println();

            switch(selection){
                case 1 -> AddMember.createMember();
                case 2 -> {
                    DisplayMember display = new DisplayMember(AddMember.getMembers());
                    display.displayMembers();
                }
                case 3 -> {
                    int memID = (int) Console.readNumber("Enter a member ID: " , 1);
                    DisplayMember display = new DisplayMember(SearchForMember.findMember(memID));
                    display.displayMember();
                }
                case 4  -> {
                    System.out.println("Returning...");
                    returnFlag = true;
                }
                default -> {
                    System.out.println("Invalid Entry. Please choose a option between 1 and 4");
                    System.out.println();
                }
            }
        }

    }
}
