package com.tournament.scoring;

import com.database.TournamentDetail;
import com.general.Console;
import com.members.Member;
import com.members.SearchForMember;
import com.tournament.SearchForTournament;
import com.tournament.Tournament;

import java.util.ArrayList;

public class AddScore {

    public static Tournament getTournament(){
        Tournament tournamentToUse = SearchForTournament.findTournament(Console.readLine("Enter Tournament Name: ", 3, 200), SearchForTournament.tList);
        tournamentToUse.displayTournamentParticipants();

        return tournamentToUse;
    }

    public static Member getMember(){
        Member memberToAdd = SearchForMember.findMember((int) Console.readNumber("Enter member ID: ", 0));

        return memberToAdd;
    }

    public static int getScore(){
        Console.nextLine();
        int score = (int) Console.readNumber("Enter Member Score: ", -20, 30);

        return score;
    }

    public static void addScore(TournamentDetail update){
        // finds the tournament by its name
        while(true){
            Tournament tournamentToUse = getTournament();

            Member memberToAdd = getMember();

            int score = getScore();

            // find member to add by ID
            Score scoreToUpdate = FindScore.findScore(memberToAdd, tournamentToUse, Score.getScoreList());
            if(memberToAdd != null && tournamentToUse != null && scoreToUpdate != null){
                scoreToUpdate.setScore(score);
                update.updateScore(memberToAdd.getMemberID(), tournamentToUse.getTournamentID(), score);
                System.out.println( memberToAdd.getName() + " score of " + score + " Successfully added to " + tournamentToUse.getName());
                break;
            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }
        }
    }

    public static void addScore(TournamentDetail update, Tournament tournament, Member member, ArrayList<Score> scoreList, int score){
        // finds the tournament by its name
            // find member to add by ID
            Score scoreToUpdate = FindScore.findScore(member, tournament, scoreList);
            if(member != null && tournament != null && scoreToUpdate != null){
                scoreToUpdate.setScore(score);
                update.updateScore(member.getMemberID(), tournament.getTournamentID(), score);
                System.out.println( member.getName() + " score of " + score + " Successfully added to " + tournament.getName());

            } else {
                System.out.println("Error Invalid Entry, Please Try again");
            }
        }

}
