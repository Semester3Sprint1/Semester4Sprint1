package com.tournament;

import com.database.TournamentDetail;
import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;

public class RemoveTournamentMember {

    public static void show(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament((int) Console.readNumber("Enter Tournament ID: ", 0));
            Member memberToDelete = SearchForMember.findMember((int) Console.readNumber("Enter Member ID: ", 0));


            // find member to remove by ID
            if (memberToDelete != null && tournamentToUse != null){
                TournamentDetail register = new TournamentDetail();
                register.removeMemberFromTournament(memberToDelete.getMemberID(), tournamentToUse.getTournamentID());

                tournamentToUse.deleteMember(memberToDelete);
                Score.getScoreList().remove(FindScore.findScore(memberToDelete, tournamentToUse));
                System.out.println(memberToDelete.getName() + " Successfully Removed from " + tournamentToUse.getName() );
                break;
            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }
        }
    }
}
