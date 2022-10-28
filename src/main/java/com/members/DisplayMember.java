package com.members;

import com.tournament.scoring.DisplayScores;

import java.util.HashMap;

public class DisplayMember {
    private Member member;
    private HashMap<Integer, Member> members;

    public DisplayMember(Member member){
        this.member = member;
    }

    public DisplayMember(HashMap<Integer, Member> members){
        this.members = members;
    }

    public void displayMembers(){
        System.out.println("\nAll Members:");
        System.out.println("Member ID" + "   " + "Member Name");
        System.out.println("---------" + "   " + "-----------");
        members.forEach((key, value) -> {
            System.out.println("    " + key + "       " + value.getName());
        });
        System.out.println();
    }

    public String displayMember(){
        if (member != null){
            System.out.println("\nMember Info: ");
            System.out.println("------------");
            System.out.println(member);
            System.out.println();
            DisplayScores.displayTournamentDetailsByMember(member.getMemberID());
            return """
                    Member Info:
                    ------------
                    """ + member.toString();
        }
        return null;
    }
}
