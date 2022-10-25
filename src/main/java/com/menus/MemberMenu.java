package com.menus;

import com.general.Console;
import com.members.*;

public class MemberMenu {

    public static void show(){
        System.out.println("Member Services Menu");
        System.out.println();

        while(true){
            System.out.println("""
                    Please Choose an Option:
                        1. Add Members
                        2. View All Members
                        3. Member Management
                        4. Back to Main
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,4);
            System.out.println();

            switch(selection){
                case 1 -> AddMember.createDefaultMember();
                case 2 -> {
                    DisplayMember display = new DisplayMember(AddMember.getMembers());
                    display.displayMembers();
                }
                case 3 -> {
                    Member memberToEdit = SearchForMember.findMember(Console.readString("Enter member ID: "));
                    EditMemberMenu editMenu = new EditMemberMenu(memberToEdit);
                    if (memberToEdit != null) editMenu.show();
                }
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
