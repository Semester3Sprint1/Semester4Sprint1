package com.menus;

import com.general.Console;
import com.members.AddMember;
import com.members.DisplayMember;
import com.members.Member;
import com.members.SearchForMember;

public class EditMemberMenu {
    private Member member;
    private final DisplayMember display;

    public EditMemberMenu(Member member) {
        this.member = member;
        this.display = new DisplayMember(member);
    }

    public void show(){
        boolean returnFlag = false;

        while(!returnFlag){
            display.displayMember();
            System.out.println("""
                    Please Choose an Option:
                        1. Edit Member Details
                        2. Change Membership Type
                        3. Delete Member
                        4. Back to Member menu
                    """);
            int selection = (int) Console.readNumber("Enter Selection: " , 1,4);
            System.out.println();

            switch(selection){
                case 1 -> System.out.println("Edit Member Details");
                case 2 -> {
                    member.setMembership(AddMember.choosePlanType());
                }
                case 3 -> {
                    AddMember.removeMembers(member);
                    System.out.println("Member Erased.");
                    returnFlag = true;
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
