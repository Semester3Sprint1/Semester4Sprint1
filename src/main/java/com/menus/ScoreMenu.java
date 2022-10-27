package com.menus;

import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.Score;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

public class ScoreMenu {

    public static void show(){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name : ", 3, 200), SearchForTournament.tList);
            Member memberToAdd = SearchForMember.findMember((int) Console.readNumber("Enter member ID: ", 0));
            Console.nextLine();
            int score = (int) Console.readNumber("Enter Member Score: ", -20, 30);
            // find member to add by ID
            Score scoreToUpdate = FindScore.findScore(memberToAdd, tournamentToUse, Score.getScoreList());
            if(memberToAdd != null && tournamentToUse != null && scoreToUpdate != null){
                scoreToUpdate.setScore(score);
                System.out.println(memberToAdd.getMemberID() + "score of " + score + " Successfully added to " + tournamentToUse.getName());
                break;
            }else{
                System.out.println("Error Invalid Entry, Please Try again");
            }


        }



    }


}
