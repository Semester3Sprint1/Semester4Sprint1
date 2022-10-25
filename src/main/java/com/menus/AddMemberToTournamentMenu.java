package com.menus;

import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class AddMemberToTournamentMenu {

    public static void show(){
        // finds the tournament by its name
        Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : "));
        // find member to add by ID
        Member memberToAdd = SearchForMember.findMember(Console.readString("Enter member ID: "));
        tournamentToUse.addMember(memberToAdd);
    }
}
