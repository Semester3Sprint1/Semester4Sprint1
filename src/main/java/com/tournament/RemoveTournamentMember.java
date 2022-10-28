package com.tournament;

import com.database.TournamentDetail;
import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.scoring.FindScore;
import com.tournament.scoring.Score;

import java.util.ArrayList;

public class RemoveTournamentMember {

    public static void show(TournamentDetail delete){
        // finds the tournament by its name
        while(true){

            int tournamentId = (int) Console.readNumber("Enter Tournament ID: ", 0 );
            Tournament tournamentToUse = SearchForTournament.findTournament( tournamentId);
            int memberId = (int)Console.readNumber("Enter Member ID: ", 0);
            Member memberToDelete = SearchForMember.findMember(( memberId));

            // find member to remove by ID
            if (memberToDelete != null && tournamentToUse != null){
                System.out.println("is the test getting here");
                delete.removeMemberFromTournament(memberToDelete.getMemberID(), tournamentToUse.getTournamentID());

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
