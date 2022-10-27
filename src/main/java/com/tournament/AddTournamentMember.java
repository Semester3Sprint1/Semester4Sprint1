package com.tournament;

import com.database.RegisterMember;
import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.Score;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class AddTournamentMember {

    public static void show(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament((int) Console.readNumber("Enter Tournament ID: ", 0));
            Member memberToAdd = SearchForMember.findMember((int) Console.readNumber("Enter Member ID: ", 0));

            // find member to add by ID
            if(memberToAdd != null && tournamentToUse != null){
                RegisterMember register = new RegisterMember();
                register.joinMemberAndTournament(memberToAdd.getMemberID(), tournamentToUse.getTournamentID());

                tournamentToUse.addMember(memberToAdd);
                Score.getScoreList().add(new Score(memberToAdd, tournamentToUse));
                System.out.println(memberToAdd.getName() + " Successfully added to " + tournamentToUse.getName());
                break;
            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }
        }
    }
}
