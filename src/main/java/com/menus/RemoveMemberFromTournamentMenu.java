package com.menus;

import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class RemoveMemberFromTournamentMenu {

    public static void show(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : ", 3, 200), SearchForTournament.tList);
            Member memberToDelete = SearchForMember.findMember((int) Console.readNumber("Enter member ID: ", 0));
            Console.nextLine();
            // find member to remove by ID
            if(memberToDelete != null && tournamentToUse != null){
                tournamentToUse.deleteMember(memberToDelete);
                System.out.println(memberToDelete.getMemberID() + " Successfully Removed from " + tournamentToUse.getName() );
                break;
            }else{
                System.out.println("Error Invalid Entry, Please Try again");
            }


        }



    }
}
