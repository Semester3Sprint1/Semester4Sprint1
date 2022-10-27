package com.tournament;

import com.general.DateCheck;
import com.general.DateValidator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.function.Predicate;

public class DisplayScores {
    public static void displayScores(ArrayList<Score> scoreList, Tournament check ){
        System.out.println("Tournament Standings");
        System.out.println("--------------------");
        System.out.println("Member Name:" + "       " + "Score" );
        System.out.println("------------" + "       " + "-----");
        scoreList.stream().filter(m->m.getTournament().getName().equals(check.getName()))
                .forEach(System.out::println);
    }

    public static void displayScores(Tournament check ){
        System.out.println("Tournament Standings");
        System.out.println("--------------------");
        System.out.println("Member Name:" + "       " + "Score" );
        System.out.println("------------" + "       " + "-----");
        ArrayList<Score> scoreList = Score.getScoreList();
        scoreList.stream().filter(m->m.getTournament().getName().equals(check.getName()))
                .forEach(System.out::println);
    }

    public static void displayTournamentDetailsByMember(int memberID){
        ArrayList<Score> scoreList = Score.getScoreList();

        System.out.println("Past Tournaments");
        System.out.println("----------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == 1)
                .forEach(m-> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
        System.out.println();
        System.out.println("Current Tournaments");
        System.out.println("-------------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == 0)
                .forEach(m-> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
        System.out.println();
        System.out.println("Registered Tournaments");
        System.out.println("----------------------");
        scoreList.stream().filter(m->m.getMember().getMemberID() == memberID).filter(m-> m.getTournament().tournamentDateCheck() == -1)
                .forEach(m-> System.out.println(m.getTournament().getName() +  " - Score: (" + m.getScore() +")"));
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
