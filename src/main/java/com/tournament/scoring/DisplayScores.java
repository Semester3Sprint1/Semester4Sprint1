package com.tournament.scoring;

import com.tournament.Tournament;

import java.util.ArrayList;
import java.util.Comparator;

public class DisplayScores {
    public static void displayScores(ArrayList<Score> scoreList, Tournament check ){
        System.out.println("Tournament Standings");
        System.out.println("--------------------");
        System.out.println("Member Name:" + "       " + "Score" );
        System.out.println("------------" + "       " + "-----");
        scoreList.stream().filter(m->m.getTournament().getName().equals(check.getName()))
                .sorted(Comparator.comparing(Score::getScore))
                .forEach(System.out::println);
    }

    public static void displayScores(Tournament check ){
        System.out.println("Tournament Standings");
        System.out.println("--------------------");
        System.out.println("Member Name:" + "       " + "Score" );
        System.out.println("------------" + "       " + "-----");
        ArrayList<Score> scoreList = Score.getScoreList();
        scoreList.stream().filter(m->m.getTournament().getName().equals(check.getName()))
                .sorted(Comparator.comparing(Score::getScore))
                .forEach(System.out::println);
    }

    public static void displayTournamentDetailsByMember(int memberID){
        ArrayList<Score> scoreList = Score.getScoreList();

        // Past
        displayMemberTournamentDetails(memberID, scoreList, 1);

        // Present
        displayMemberTournamentDetails(memberID, scoreList, 0);

        //Future
        displayMemberTournamentDetails(memberID, scoreList, -1);
    }

    public static void displayMemberTournamentDetails(int memberID, ArrayList<Score> scoreList, int dateCheck){
        switch (dateCheck){
            case 1 -> System.out.println("Past Tournaments");
            case 0 -> System.out.println("Ongoing Tournaments");
            case -1 -> System.out.println("Registered Tournaments");
        }
        System.out.println("----------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == dateCheck)
                .forEach(m -> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
        System.out.println();
    }

    public static void displayTournamentDetailsByMember(ArrayList<Score> scoreList, int memberID){
        System.out.println("Past Tournaments");
        System.out.println("----------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == 1)
                .forEach(m-> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
        System.out.println();

        System.out.println("Current Tournaments");
        System.out.println("----------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == 0)
                .forEach(m-> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
        System.out.println();

        System.out.println("Registered Tournaments");
        System.out.println("----------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == -1)
                .forEach(m-> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
        System.out.println();
    }
}
