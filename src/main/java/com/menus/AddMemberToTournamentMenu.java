package com.menus;

import com.database.RegisterMember;
import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class AddMemberToTournamentMenu {

    public static void show(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : ", 3, 200), SearchForTournament.tList);
            Member memberToAdd = SearchForMember.findMember((int) Console.readNumber("Enter member ID: ", 0));
            Console.nextLine();

            //RegisterMember register = new RegisterMember();
            //register.joinMemberAndTournament(memberToAdd.getMemberID(), tournamentToUse.getTournamentID());

            // find member to add by ID
            if(memberToAdd != null && tournamentToUse != null){
                tournamentToUse.addMember(memberToAdd);
                System.out.println(memberToAdd.getMemberID() + " Successfully added to " + tournamentToUse.getName());
                break;
            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }


        }



    }
}
